package org.auction

class DeliverOption {
    String name
    static hasMany = [listings: Listing ]
    static constraints = {
    }
}
