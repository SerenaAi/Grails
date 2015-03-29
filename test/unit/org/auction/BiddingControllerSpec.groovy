package org.auction

import grails.test.mixin.*
import spock.lang.*

@TestFor(BiddingController)
@Mock(Bidding)
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

    void "Test that the save action returns the correct model"() {
        when:"The save action is executed with a null domain"
            controller.save(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the save action"
            populateValidParams(params)
            def bidding = new Bidding(params)
            controller.save(bidding)

        then:"A model is populated containing the domain instance"
            model.biddingInstance == bidding
    }
}
