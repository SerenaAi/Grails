package org.auction

class Account {
    String address
    String email
    String name
    String password
    int type
    Date lastUpdated

    static hasMany = [listings: Listing]
    static constraints = {
        address(blank: false)
        email(blank: false)
        name(blank: false, size: 2..20)
        password(blank: false, size: 8..16)
    }
    static mapping = {
        autoTimestamp true
    }
}