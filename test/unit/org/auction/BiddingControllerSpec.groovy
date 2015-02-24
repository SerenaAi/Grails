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

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.biddingInstanceList
            model.biddingInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.biddingInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def bidding = new Bidding()
            bidding.validate()
            controller.save(bidding)

        then:"The create view is rendered again with the correct model"
            model.biddingInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            bidding = new Bidding(params)

            controller.save(bidding)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/bidding/show/1'
            controller.flash.message != null
            Bidding.count() == 1
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

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/bidding/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def bidding = new Bidding()
            bidding.validate()
            controller.update(bidding)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.biddingInstance == bidding

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            bidding = new Bidding(params).save(flush: true)
            controller.update(bidding)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/bidding/show/$bidding.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/bidding/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def bidding = new Bidding(params).save(flush: true)

        then:"It exists"
            Bidding.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(bidding)

        then:"The instance is deleted"
            Bidding.count() == 0
            response.redirectedUrl == '/bidding/index'
            flash.message != null
    }
}
