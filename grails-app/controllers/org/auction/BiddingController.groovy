package org.auction

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BiddingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def springSecurityService= new SpringSecurityService()

    def show(Bidding biddingInstance) {
        respond biddingInstance
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def create() {
        Bidding bidding=new Bidding(params)
        bidding.listing=Listing.findById(params.id)

        User user = springSecurityService.currentUser
        Role bidderRole=Role.findByAuthority("BIDDER")
        UserRole.create user, bidderRole, true
        Account account= Account.findByUsername(user.username)
        bidding.biddingAccount=account
        respond bidding
    }

    @Transactional
    def save(Bidding biddingInstance) {
        if (biddingInstance == null) {
            notFound()
            return
        }
        if (biddingInstance.hasErrors()) {
            respond biddingInstance.errors, view:'create', controller:"bidding"
            return
        }
        biddingInstance.save flush:true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bidding.label', default: 'Bidding'), biddingInstance.id])
                redirect biddingInstance
            }
            '*' { respond biddingInstance, [status: CREATED]}
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bidding.label', default: 'Bidding'), params.id])
                     return
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
