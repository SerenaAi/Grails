package org.auction

import com.sun.swing.internal.plaf.basic.resources.basic_de
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

class BiddingRestController extends RestfulController<Bidding> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    BiddingRestController() {
        super(Bidding)
    }

    @Override
    def index(Integer max) {
        def lid = params.listingRestId
        if (params.listingRestId) {
            List <Bidding> biddings = Bidding.where {
                listing.id == lid
            }.list(params)
            respond biddings
        } else {
            super.index(max)
        }
    }

    @Override
    def show() {
        def bidding = queryForResource(params.id)
        if (bidding) {
            if (params.listingRestId) {
                String curlid = bidding.listing.id
                String lid = params.listingRestId
                if (curlid.equals(lid)) {
                    respond bidding
                } else {
                    respond null
                }
            } else {
                respond bidding
            }
        }
        respond null
    }

    //changed
    def save() {
        def instance = new Bidding()
        bindData instance, request
        instance.validate()
        if (instance.hasErrors()) {
            response.status = 404;
            respond status:404, message:"invalid instance"
        }
        instance.save flush: true
        respond instance
    }
}
