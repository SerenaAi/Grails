package org.auction

import grails.test.mixin.*
import spock.lang.*

@TestFor(DeliverOptionController)
@Mock(DeliverOption)
class DeliverOptionControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.deliverOptionInstanceList
            model.deliverOptionInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.deliverOptionInstance!= null
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def deliverOption = new DeliverOption(params)
            controller.show(deliverOption)

        then:"A model is populated containing the domain instance"
            model.deliverOptionInstance == deliverOption
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def deliverOption = new DeliverOption(params)
            controller.edit(deliverOption)

        then:"A model is populated containing the domain instance"
            model.deliverOptionInstance == deliverOption
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/deliverOption/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def deliverOption = new DeliverOption(params).save(flush: true)

        then:"It exists"
            DeliverOption.count() != 1

        when:"The domain instance is passed to the delete action"
            controller.delete(deliverOption)

        then:"The instance is deleted"
            DeliverOption.count() == 0
            response.redirectedUrl == '/deliverOption/index'
            flash.message != null
    }
}
