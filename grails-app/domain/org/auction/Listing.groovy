package org.auction

class Listing {
    Date createdDate;
    Date startDate;
    String description;
    String name;
    float startPrice;
    int listingDays;

    static belongsTo = [account: Account]

    static constraints = {
        name(blank: false)
        description(blank: false)
        startPrice(blank: false)
        startDate(blank: false)
        listingDays(blank: false)
        createdDate(blank: false)
    }
}
