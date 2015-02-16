package org.auction

class SellerAccount {
    String email;
    static hasOne = [email: Account]
    static constraints = {
    }
}
