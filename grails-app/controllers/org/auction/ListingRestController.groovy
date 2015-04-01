package org.auction

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

class ListingRestController extends RestfulController<Listing> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    ListingRestController() {
        super(Listing)
    }

    @Secured(['permitAll'])
    def index(Integer max, String completed) {
        params.max = Math.min(max ?: 10, 100)
        def listings
        if( completed.equals('true') || completed.equals('false') ){
            listings = Listing.where { completed == completed}.list(params)
        }else{
            listings = Listing.list(params)
        }
        respond listings
    }

    @Secured(['permitAll'])
    @Override
    def show() {
        super.show()
    }
}
