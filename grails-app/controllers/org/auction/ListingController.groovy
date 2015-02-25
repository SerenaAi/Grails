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
        def criteria1 = Listing.createCriteria()
        def result1;

        if(params.searchtype){
            println "st "+params.searchtype
            if(params.searchtype=="1"){
                result1 = criteria1 {
                        ilike('name', "%${params.query}%")
                }
            }
            else{
                result1 = criteria1 {
                        ilike('description', "%${params.query}%")
                }
            }
        }else{ result1=criteria1{ }}

        def criteria2 = Listing.createCriteria()
        def result2;
        if(params.listtype){
            if(params.listtype=="2"){
                result2= criteria2 {
                    eq('completed', true)
                }
            }else if(params.listtype=="3"){
                result2=criteria2 {
                    eq('completed', false)
                }
            }else{
                result2=criteria2{ }
            }
        }else{ result2=criteria2{ }}

        def retResult = result1.intersect(result2)
        println retResult
        respond retResult, model: [listingInstanceCount: retResult.size()], view: 'index'
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
