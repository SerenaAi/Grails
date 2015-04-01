package org.auction

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.servlet.HttpHeaders

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NO_CONTENT

class ListingRestController extends RestfulController<Listing> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']
    def springSecurityService= new SpringSecurityService()
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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

    @Secured(['permitAll'])
    @Override
    def delete() {
        if(handleReadOnly()) {
            return
        }
        def instance = queryForResource(params.id)
        if (instance == null) {
            return
        }
        instance.delete flush:true
        respond instance
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    @Override
    def save() {
        def user=springSecurityService.currentUser
        def account=Account.findByUsername(user.username)
        int aid=account.id as int

        if(handleReadOnly()) {
            return
        }
        def instance = new Listing()
        bindData instance, request

        instance.validate()
        if (instance.hasErrors()) {
            respond instance.errors
            return
        }
        def sid = instance.sellerAccount.id as int
        if(aid!=sid){
            return
        }
        instance.save flush:true
        redirect instance
    }


    @Secured(["IS_AUTHENTICATED_FULLY"])
    @Override
    def update() {
        def user=springSecurityService.currentUser
        def account=Account.findByUsername(user.username)
        int aid=account.id as int

        if(handleReadOnly()) {
            return
        }
        Listing instance = Listing.findById(params.id)
        if(!instance){
            return
        }

        bindData instance, request

        if (instance.hasErrors()) {
            respond instance.errors
            return
        }
        def sid = instance.sellerAccount.id as int
        if(aid!=sid){
            return
        }
        instance.save flush:true
        redirect instance
    }

}

