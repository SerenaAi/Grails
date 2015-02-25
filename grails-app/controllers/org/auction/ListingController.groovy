package org.auction

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

class ListingController {

    def create() {
        respond new Listing(params)
    }
    def show(Listing listingInstance) {
        respond listingInstance
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.offset = params.offset as Integer ?: 0
        def criteria1 = Listing.createCriteria()
        def criteria2 = Listing.createCriteria()
        def result1, total = 0, retResult

        if (params.searchtype) {
            def field
            if (params.searchtype == "1")
                field = "name"
            else
                field = "description"
            result1 = criteria1.list(max: 10, offset: params.offset) {
                ilike(field, "%${params.query}%")
            }
        } else {
            result1 = criteria1.list(max: 10, offset: params.offset) {}
        }
        total = result1.getTotalCount()

        def result2;
        if (params.listtype) {
            def comp
            if (params.listtype == "2")
                comp = true
            else if (params.listtype == "3")
                comp = false
            if (comp == true || comp == false)
                result2 = criteria2.list(max: 10, offset: params.offset) {
                    eq('completed', comp)
                } else
                result2 = criteria2.list(max: 10, offset: params.offset) {}
        } else {
            result2 = criteria2.list(max: 10, offset: params.offset) {}
        }
        total = result2.getTotalCount()

        retResult = result1.intersect(result2)
        respond retResult, model: [listingInstanceCount: total], view: 'index'
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
