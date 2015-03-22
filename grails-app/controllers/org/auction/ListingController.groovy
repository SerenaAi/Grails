package org.auction

import grails.transaction.Transactional
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.*

class ListingController {

    def create() {
        respond new Listing(params)
    }
    def show(Listing listingInstance) {
        respond listingInstance
    }
    @Secured(closure = {
        authentication.principal.username == "miao"
    })
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.offset = params.offset as Integer ?: 0
        def criteria1 = Listing.createCriteria()
        def total = 0, retResult

        retResult = criteria1.list(max: 10, offset: params.offset) {
            and {
                if (params.query && params.searchtype == "1")
                    ilike("username", "%${params.query}%")
                if (params.query && params.searchtype == "2")
                    ilike("description", "%${params.query}%") 
                if (params.listtype == "2")
                     eq('completed', true)
                if (params.listtype == "3")
                     eq('completed', false)
            }
        }
        total += retResult.getTotalCount()
        respond retResult, model: [listingInstanceCount: total], view: 'index', params:params
    }

    @Transactional
    def save(Listing listingInstance) {
        if (listingInstance == null) {
            notFound()
            return
        }
        if (listingInstance.hasErrors()) {
            respond listingInstance.errors, view: 'create'
            return
        }
        listingInstance.save flush: true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'listing.label',
                    default: 'Listing'), listingInstance.id])
                redirect listingInstance
            }
            '*' {
                respond listingInstance, [status: CREATED]
            }
        }
    }
    def edit(Listing listingInstance) {
        respond listingInstance
    }
    @Transactional
    def update(Listing listingInstance) {
        if (listingInstance == null) {
            notFound()
            return
        }
        if (listingInstance.hasErrors()) {
            respond listingInstance.errors, view: 'edit'
            return
        }
        listingInstance.save flush: true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Listing.label',
                    default: 'Listing'), listingInstance.id])
                redirect listingInstance
            }
            '*' {
                respond listingInstance, [status: OK]
            }
        }
    }

    @Transactional
    def delete(Listing listingInstance) {
        if (listingInstance == null) {
            notFound()
            return
        }
        listingInstance.delete flush: true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Listing.label',
                    default: 'Listing'), listingInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' {
                render status: NO_CONTENT
            }
        }
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'listing.label',
                    default: 'Listing'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' {
                render status: NOT_FOUND
            }
        }
    }
}
