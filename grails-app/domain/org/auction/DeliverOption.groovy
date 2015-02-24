package org.auction

class DeliverOption {
    int id
    String name
    static hasMany = [listings: Listing ]
    static constraints = {
    }
}
