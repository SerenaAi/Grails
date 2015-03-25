package org.auction
import grails.rest.RestfulController

class AccountRestController extends RestfulController<Account> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']

    AccountRestController() {
        super(Account)
    }

    def index(Integer max) {
        super.index(1)
        def accounts = Account.getAll();
        respond accounts
    }
}
