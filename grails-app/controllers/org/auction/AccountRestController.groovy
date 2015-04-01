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
        User user= springSecurityService.currentUser
        def account = Account.findByUsername(user.username)
        int aid = account.id as int
        int pid = params.id as int
        if(pid==aid){
            super.show()
        }
        respond null
    }


    @Secured(["IS_AUTHENTICATED_FULLY"])
    def edit(){
        println "edit"
        super.edit()

    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def update(){
        println "update"
        User user= springSecurityService.currentUser
        def account = Account.findByUsername(user.username)
        int aid = account.id as int
        int pid = params.id as int
        if(pid==aid){
            if(handleReadOnly()) {
                return
            }

            Account instance = queryForResource(params.id)
            if (instance == null) {
                respond "error"
            }
            println "i: "+instance
            bindData instance, getObjectToBind()
            println "p: "+instance.properties
            if (instance.hasErrors()) {
                respond "error"
            }

            instance.save flush:true
            respond instance

        }
        respond null
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    protected getObjectToBind() {
        println request
        request
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def Account createResource() {
        Account instance = resource.newInstance()
        bindData instance, getObjectToBind()
        instance
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def create() {
        if(handleReadOnly()) {
            return
        }
        respond createResource()
    }

}
