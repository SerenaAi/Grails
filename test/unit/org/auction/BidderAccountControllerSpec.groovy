package org.auction



import grails.test.mixin.*
import spock.lang.*

@TestFor(BidderAccountController)
@Mock(BidderAccount)
class BidderAccountControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.bidderAccountInstanceList
            model.bidderAccountInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.bidderAccountInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def bidderAccount = new BidderAccount()
            bidderAccount.validate()
            controller.save(bidderAccount)

        then:"The create view is rendered again with the correct model"
            model.bidderAccountInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            bidderAccount = new BidderAccount(params)

            controller.save(bidderAccount)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/bidderAccount/show/1'
            controller.flash.message != null
            BidderAccount.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def bidderAccount = new BidderAccount(params)
            controller.show(bidderAccount)

        then:"A model is populated containing the domain instance"
            model.bidderAccountInstance == bidderAccount
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def bidderAccount = new BidderAccount(params)
            controller.edit(bidderAccount)

        then:"A model is populated containing the domain instance"
            model.bidderAccountInstance == bidderAccount
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/bidderAccount/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def bidderAccount = new BidderAccount()
            bidderAccount.validate()
            controller.update(bidderAccount)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.bidderAccountInstance == bidderAccount

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            bidderAccount = new BidderAccount(params).save(flush: true)
            controller.update(bidderAccount)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/bidderAccount/show/$bidderAccount.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/bidderAccount/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def bidderAccount = new BidderAccount(params).save(flush: true)

        then:"It exists"
            BidderAccount.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(bidderAccount)

        then:"The instance is deleted"
            BidderAccount.count() == 0
            response.redirectedUrl == '/bidderAccount/index'
            flash.message != null
    }
}
