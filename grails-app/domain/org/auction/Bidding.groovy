package org.auction

class Bidding {
    float amount;
    Date dateCreated;
    Account account;

    static belongsTo = [listing:Listing]
    static constraints = {
    }
    static mapping={
        autoTimestamp true
    }
}
