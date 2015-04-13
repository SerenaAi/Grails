package org.auction

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

class DeliveroptionsRestController extends RestfulController<DeliverOption> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    DeliveroptionsRestController() {
        super(DeliverOption)
    }

    def show() {
        super.show()
    }
    def index(Integer max){
        super.index(max)
    }
}
