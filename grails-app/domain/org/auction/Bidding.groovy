package org.auction

class Bidding {
    float amount;
    Date dateCreated;

    static belongsTo = [listing:Listing, biddingAccount:Account]
    static constraints = {
        amount validator: {val, obj->
            def min;
            if (Bidding.count() == 0) {
                min=obj.listing.startPrice
            }
            else {
                if (!Bidding.findByListing(obj.listing)) {
                    min=obj.listing.startPrice
                } else {
                    def min2=Bidding.createCriteria().get{
                        projections{
                            eq('listing',obj.listing)
                            max "amount"
                        }
                    }
                    min=min2+0.5;
                }
            }
            if (obj.amount>=min) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    static mapping={
        autoTimestamp true
    }
}
