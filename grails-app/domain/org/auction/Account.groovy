package org.auction

class Account {
    String address
    String email
    String name
    String password
    Date lastUpdated
    int thumbUp=0
    int thumbDown=0
    static belongsTo = org.auction.Review
    static hasMany = [listings: Listing, biddings: Bidding, receivedReviews: Review, sentReviews: Review]

    static mappedBy = [listings: 'sellerAccount',
                         biddings: 'biddingAccount',
                         receivedReviews:  'revieweeAccount',
                         sentReviews:  'reviewerAccount'
                         ]
    static constraints = {
      address(blank: false)
      email(blank: false, email: true)
      name(blank: false)
      password(blank: false, size: 8..16)
      password validator: { val-> return ( val.find(/[A-Z]/)|| val.find(/[a-z]/) ) && val.find(/\d/)}
    }

    static mapping={
        address(blank: false)
        email(blank: false)
        name(blank: false)
        password(blank: false, size: 8..16)
    }
}