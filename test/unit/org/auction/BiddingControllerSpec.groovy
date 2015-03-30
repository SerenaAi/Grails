package org.auction

import grails.test.mixin.*
import spock.lang.*

@TestFor(BiddingController)
@Mock([Bidding,Account,Listing,UserRole,Role])
class BiddingControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def bidding = new Bidding(params)
            controller.show(bidding)

        then:"A model is populated containing the domain instance"
            model.biddingInstance == bidding
    }

    void "Test that the create action returns the correct model" () {
        setup:
            Date date = new Date();
            def account = new Account(
                username : "a",
                email    : "a@a.com",
                address  : "a",
                password : "1aaaaaaa"
            )
            account.save(failOnError: true);

            def listing = new Listing(
                deliverOption  : new DeliverOption(),
                description    : "aa",
                highBid        : 33.34,
                highBidAccount : account,
                listingDays    : 2,
                name           : "a",
                sellerAccount  : account,
                startDate      : date,
                startPrice     : 19.23,
            ).save(failOnError: true)
        params["id"] = listing.id

        when: "Create action run"
            controller.create()

        then: "Model created correctly"
            model.biddingInstance != null
    }
}
