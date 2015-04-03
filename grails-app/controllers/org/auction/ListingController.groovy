package org.auction

import grails.transaction.Transactional
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.*

class ListingController {

    def springSecurityService = new SpringSecurityService()

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def create() {
        Listing listing = new Listing(params)
        User user = springSecurityService.currentUser
        if (user) {
            Account account = Account.findByUsername(user.username)
            listing.sellerAccount = account
            respond listing
        } else {
            redirect controller: "login", action: "denied"
        }
    }

    @Secured(["permitAll"])
    def show(Listing listingInstance) {
        respond listingInstance
    }

    @Secured(["permitAll"])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.offset = params.offset as Integer ?: 0
        def criteria1 = Listing.createCriteria()
        def total = 0, retResult

        retResult = criteria1.list(max: 10, offset: params.offset) {
            and {
                if (params.query && params.searchtype == "1")
                    ilike("name", "%${params.query}%")
                if (params.query && params.searchtype == "2")
                    ilike("description", "%${params.query}%")
                if (params.listtype == "2")
                    eq('completed', true)
                if (params.listtype == "3")
                    eq('completed', false)
            }
        }
        total += retResult.getTotalCount()
        respond retResult, model: [listingInstanceCount: total], view: 'index', params: params
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
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
                flash.message = message(code: 'default.created.message', args: [message(
                    code: 'listing.label',
                    default: 'Listing'
                ), listingInstance.id])
                redirect listingInstance
            }
            '*' {
                respond listingInstance, [status: CREATED]
            }
        }
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def edit(Listing listingInstance) {
        User user = springSecurityService.currentUser;
        if (user) {
            if (listingInstance.sellerAccount.username.equals(user.username)) {
                respond listingInstance
            } else {
                redirect controller: "login", action: "denied"
            }
        } else {
            redirect controller: "login", action: "denied"
        }
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
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
                flash.message = message(code: 'default.updated.message', args: [message(
                    code: 'Listing.label',
                    default: 'Listing'
                ), listingInstance.id])
                redirect listingInstance
            }
            '*' {
                respond listingInstance, [status: OK]
            }
        }
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def delete(Listing listingInstance) {
        if (listingInstance == null) {
            notFound()
            return
        }

        User user= springSecurityService.currentUser;
        if(user){
            if(listingInstance.sellerAccount.username.equals(user.username) ){
                listingInstance.delete flush: true
                request.withFormat {
                    form multipartForm {
                        flash.message = message(code: 'default.deleted.message', args: [message(
                            code: 'Listing.label',
                            default: 'Listing'
                        ), listingInstance.id])
                        redirect action: "index", method: "GET"
                    }
                    '*' {
                        render status: NO_CONTENT
                    }
                }
            }else{
                redirect controller: "login", action:"denied"
            }
        }else{
            redirect controller: "login", action:"denied"
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(
                    code: 'listing.label',
                    default: 'Listing'
                ), params.id])
                redirect action: "index", method: "GET"
            }
            '*' {
                render status: NOT_FOUND
            }
        }
    }
}
