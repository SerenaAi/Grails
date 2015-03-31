package org.auction

import grails.rest.Resource

class Account {
    String address
    String email
    String username
    String password
    Date lastUpdated

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
        username(blank: false)
        password(blank: false, size: 8..16)
        password validator: { val-> return ( val.find(/[A-Z]/)|| val.find(/[a-z]/) ) && val.find(/\d/)}
    }

	static mapping = {
        address(blank: false)
        email(blank: false, unique: true)
        username(blank: false, unique: true)
        password(blank: false, size: 8..16)
	}
}
