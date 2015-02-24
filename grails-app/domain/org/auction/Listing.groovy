package org.auction

class Listing {
    Date startDate;
    String description;
    String name;
    float startPrice;
    int listingDays ;
    boolean completed;

    static belongsTo = [account: Account, deliverOption: DeliverOption]
    static hasMany=[biddings: Bidding]
    static constraints = {
        name(blank: false)
        description(blank: false)
        startPrice(blank: false)
        startDate(blank: false )
        listingDays(blank: false)
        completed validator: { val, obj->
            Date currentDate = new Date();
            Date expireDate=obj.startDate+obj.listingDays

            if(currentDate.compareTo(expireDate)>=0) obj.completed=true
            else obj.completed=false;
            return true;
        }
    }

}
