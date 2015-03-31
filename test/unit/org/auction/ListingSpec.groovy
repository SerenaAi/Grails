package org.auction

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Listing)
class ListingSpec extends Specification {
    def listing;
    def setup() {
        listing = new Listing()
    }

    def cleanup() {
        listing.delete();
    }

    def "Test when certain listing properties are valid/invalid" () {
        when:
            listing.setDeliverOption(delivery)
            listing.setDescription(desc)
            listing.setHighBid(hBid)
            listing.setHighBidAccount(hBidAcct)
            listing.setListingDays(days)
            listing.setName(name)
            listing.setSellerAccount(acct)
            listing.setStartDate(date)
            listing.setStartPrice(price)
        then:
            listing.validate() == status 
        where:
            delivery            | desc                 | hBid  | hBidAcct      | days | name               | acct          | date           | price | status
            new DeliverOption() | 'Awesome Galaxy S6 ' | 12.34 | new Account() | 1    | ''                 | new Account() | new Date() - 1 | 23.12 | false
            new DeliverOption() | 'Awesome PC S6 '     | 2.34  | new Account() | 2    | 'Bad product'      | new Account() | new Date() + 1 | 4.12  | true
            new DeliverOption() | 'Awesome Candel S6 ' | 2.34  | new Account() | 0    | 'Table programmer' | new Account() | new Date() + 2 | 2.12  | false
            new DeliverOption() | 'Awesome Toilet S6 ' | -2.34 | new Account() | 9    | 'Nice Toilet'      | new Account() | new Date() + 1 | 23.12 | true
            new DeliverOption() | 'Awesome Font S6 '   | 1.34  | null          | 23   | 'Bat'              | new Account() | new Date() + 5 | 23.12 | true
    }
    
    void "Test when all parameters are valid" () {
        setup:
            Date date = new Date();
            def count = Listing.count();
        when:
            Listing listing = new Listing(
                completed      : false,
                deliverOption  : new DeliverOption(),
                description    : "aa",
                highBid        : 12.34,
                highBidAccount : new Account(),
                listingDays    : 2,
                name           : "a",
                sellerAccount  : new Account(),
                startDate      : date,
                startPrice     : 1,
            ).save(failOnError: true)
        then:
            count + 1 == Listing.count()
    }

    void "Test when some parameters are invalid" () {
        setup:
            Date date = new Date();
            def count = Listing.count();
        when:
            Listing listing = new Listing(
                completed      : false,
                deliverOption  : new DeliverOption(),
                description    : "aa",
                highBid        : 12.34,
                highBidAccount : null,
                listingDays    : 2,
                name           : "a",
                sellerAccount  : null,
                startDate      : date,
                startPrice     : 1,
            ).save(failOnError: true)
        then:
            count == Listing.count()
            thrown(grails.validation.ValidationException)
    }

    void "Test completed field status when complete" () {
        setup:
            Date date = new Date();
            date = date - 2;
        when:
            Listing listing = new Listing(
                completed      : false,
                deliverOption  : new DeliverOption(),
                description    : "aa",
                highBid        : 12.34,
                highBidAccount : new Account(),
                listingDays    : 2,
                name           : "a",
                sellerAccount  : new Account(),
                startDate      : date,
                startPrice     : 1,
            ).save(failOnError: true)
        then:
            listing.completed == true
    }

    void "Test completed field status when not complete" () {
        setup:
            Date date = new Date();
        when:
            Listing listing = new Listing(
                completed      : false,
                deliverOption  : new DeliverOption(),
                description    : "aa",
                highBid        : 12.34,
                highBidAccount : new Account(),
                listingDays    : 2,
                name           : "a",
                sellerAccount  : new Account(),
                startDate      : date,
                startPrice     : 0,
            ).save(failOnError: true)
        then:
            listing.completed == false
    }
}
