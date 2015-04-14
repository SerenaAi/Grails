package org.auction

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.servlet.HttpHeaders

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NO_CONTENT

class ListingRestController extends RestfulController<Listing> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    ListingRestController() {
        super(Listing)
    }

    //changed
    def index(Integer max, String completed) {
        params.max = Math.min(max ?: 10, 100)
        def listings
        if (completed.equals('true') || completed.equals('false')) {
            listings = Listing.where {
                completed == completed
            }.list(params)
        } else {
            listings = Listing.list(params)
        }
        respond listings
    }

    def show() {
        super.show()
    }

    //changed
    def delete() {
        def instance = queryForResource(params.id)
        if (!instance) {
            response.status = 404;
            respond status:404, message:"cannot find instance"
        }
        instance.delete flush: true
        respond instance
    }

    //changed
    def save() {
        println "listing save"
        def instance = new Listing()
        bindData instance, request
        instance.validate()
        if (instance.hasErrors()) {
            response.status = 404;
            respond status:404, message:"invalid instance"
        }
        instance.save flush: true
        respond instance
    }

    //changed
    def update() {
        Listing instance = Listing.findById(params.id)
        if (!instance) {
            response.status = 404;
            respond status:404, message:"cannot find instance"
        }
        instance.properties = request
        if (instance.hasErrors()) {
            response.status = 404;
            respond status:404, message:"invalid instance"
        }
        instance.save flush: true
        redirect instance
    }
}

