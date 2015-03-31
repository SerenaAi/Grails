package org.auction

import grails.rest.RestfulController

class AccountRestController extends RestfulController<Account> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    AccountRestController() {
        super(Account)
    }

    @Override
    def index(Integer max) {
        super.index(max)
    }

    protected Account createResource(Map params) {
        println params
        resource.newInstance(params)
    }

}
