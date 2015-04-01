package org.auction

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

class AccountRestController extends RestfulController<Account> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    AccountRestController() {
        super(Account)
    }

    @Secured(['permitAll'])
    def show() {
        super.show()
    }
}
