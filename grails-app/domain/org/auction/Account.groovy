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