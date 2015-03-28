package org.auction

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Listing)
class ListingSpec extends Specification {
    def setup() {}

    def cleanup() {}

    void "Test when all parameters are valid" () {
        setup:
            Date date = new Date();
            def count = Listing.count();
        when:
            Listing listing = new Listing(
                description   : "aa",
                name          : "a",
                startDate     : date,
                startPrice    : 1,
                listingDays   : 2,
                account       : new Account(),
                deliverOption : new DeliverOption()
            ).save(failOnError: true)
        then:
            count + 1 == Listing.count()
    }

    void "test when some parameters are invalid" () {
        setup:
            Date date = new Date();
            def count = Listing.count();
        when:
            Listing listing = new Listing(
                description   : "aa",
                name          : "a",
                startDate     : date,
                startPrice    : 1,
                listingDays   : 2,
                account       : null,
                deliverOption : new DeliverOption()
            ).save(failOnError: true)
        then:
            count == Listing.count()
            thrown(grails.validation.ValidationException)
    }

    void "test completed field status when complete" () {
        setup:
            Date date = new Date();
            date = date - 2;
        when:
            Listing listing = new Listing(
                description   : "aa",
                name          : "a",
                startDate     : date,
                startPrice    : 1,
                listingDays   : 2,
                account       : new Account(),
                deliverOption : new DeliverOption()
            ).save(failOnError: true)
        then:
            listing.completed == true
    }

    void "test completed field status when not complete" () {
        setup:
            Date date = new Date();
        when:
            Listing listing = new Listing(
                description   : "aa",
                name          : "a",
                startDate     : date,
                startPrice    : 1,
                listingDays   : 1,
                account       : new Account(),
                deliverOption : new DeliverOption()
            ).save(failOnError: true)
        then:
            listing.completed == false
    }
}
