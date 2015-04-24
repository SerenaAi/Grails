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
            response.status = 404;
            respond status:404, message:"invalid username"
        }else{
            Account account=Account.findByUsername(name)
            if(!account){
                response.status = 404;
                respond status:404, message:"cannot find instance"
            }else{
                respond account
            }
        }
    }

    def show() {
        super.show()
    }

    //changed
    def update() {
        Account instance = Account.findById(params.id)
        if (!instance) {
            response.status = 404;
            respond status:404, message:"cannot find instance"
        }
        User user=User.findByUsername(instance.username)
        instance.properties = request
        if (instance.hasErrors()) {
            response.status = 404;
            respond status:404, message:"invalid instance"
        }
        user.username=instance.username
        user.password=instance.password
        user.save flush:true
        instance.save flush: true
        respond instance
    }
}
