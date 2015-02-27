package org.auction



import grails.test.mixin.*
import spock.lang.*

@TestFor(BiddingController)
@Mock(Bidding)
class BiddingControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
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

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def bidding = new Bidding(params)
            controller.edit(bidding)

        then:"A model is populated containing the domain instance"
            model.biddingInstance == bidding
    }
}
