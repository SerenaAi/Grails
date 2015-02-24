package org.auction

import grails.transaction.Transactional
import jdk.internal.org.objectweb.asm.tree.LdcInsnNode

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

    def index (Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.offset = params.offset as Integer ?: 0


        respond Listing.list(params), model:[listingInstanceCount: Listing.count()]
    }
    @Transactional
    def save(Listing listingInstance) {
        if (listingInstance == null) {
            notFound()
            return
        }
        if (listingInstance.hasErrors()) {
            respond listingInstance.errors, view:'create'
            return
        }
        listingInstance.save flush:true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'listing.label', default: 'Listing'), listingInstance.id])
                redirect listingInstance
            }
            '*' { respond listingInstance, [status: CREATED] }
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
            respond listingInstance.errors, view:'edit'
            return
        }
        listingInstance.save flush:true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Listing.label', default: 'Listing'), listingInstance.id])
                redirect listingInstance
            }
            '*'{ respond listingInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Listing listingInstance) {
        if (listingInstance == null) {
            notFound()
            return
        }
        listingInstance.delete flush:true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Listing.label', default: 'Listing'), listingInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'listing.label', default: 'Listing'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
