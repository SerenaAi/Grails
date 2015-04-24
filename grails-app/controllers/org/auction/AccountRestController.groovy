package org.auction

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.*
import grails.rest.RestfulController

import javax.annotation.Resource

class AccountRestController extends RestfulController<Account> {

    def springSecurityService = new SpringSecurityService()

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    AccountRestController() {
        super(Account)
    }

    def index(String name){
        if(name==null){
            respond null
        }else{
            Account account=Account.findByUsername(name)
            if(!account){
                respond null
            }else{
                respond account
            }
        }
    }

    def show() {
        super.show()
    }

    @Override
    def update() {
        def user = springSecurityService.currentUser
        def account = Account.findByUsername(user.username)
        int aid = account.id as int

        if (handleReadOnly()) {
            return
        }
        Account instance = Account.findById(params.id)
        if (!instance) {
            return
        }
        instance.properties = request

        if (instance.hasErrors()) {
            respond instance.errors
            return
        }
        def id = instance.id as int
        if (aid != id) {
            return
        }
        instance.save flush: true
        redirect instance
    }
}
