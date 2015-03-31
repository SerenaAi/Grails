package org.auction

import grails.rest.RestfulController

class ListingRestController  extends RestfulController<Listing> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    ListingRestController() {
        super(Listing)
    }

    def index(Integer max) {
        super.index(max)
    }
}
