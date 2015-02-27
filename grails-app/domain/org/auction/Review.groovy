package org.auction

class Review {

    static belongsTo = [reviewer: Account, reviewing: Account, listing: Listing]

    Account reviewer 
    Account reviewing
    Listing listing

    Boolean voted 
    String comment

    static constraints = {
        comment size: 0..50
    }
}
