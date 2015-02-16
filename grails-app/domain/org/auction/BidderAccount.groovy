package org.auction

class BidderAccount {
    String email;
    static hasOne = [email: Account]
}
