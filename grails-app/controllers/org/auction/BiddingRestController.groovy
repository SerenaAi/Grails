package org.auction

import com.sun.swing.internal.plaf.basic.resources.basic_de
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
        if(params.listingRestId){
            println params
            println id
            List<Bidding> biddings = Bidding.where { listing.id == lid }.list(params)
            println biddings
            respond biddings
        }else{
            super.index(max)
        }
    }

}
