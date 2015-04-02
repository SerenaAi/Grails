package org.auction

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReviewController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def springSecurityService= new SpringSecurityService()

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def show(Review reviewInstance) {
        User user=springSecurityService.currentUser
        Account account=Account.findByUsername(user.username)

        if( Listing.findByHighBidAccount(account) ||
                Listing.findBySellerAccount(account) ){
        }else{ redirect action:"denied", controller:"login"}

        respond reviewInstance
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def createseller() {
        User user=springSecurityService.currentUser
        Account account=Account.findByUsername(user.username)

        if( Listing.findByHighBidAccount(account) ||
                Listing.findBySellerAccount(account) ){
        }else{ redirect action:"denied", controller:"login"}

        Account rwrAccount= Account.findByUsername(user.username)
        def revieweeId= params.name
        def listingId= params.id

        Review review=new Review(params)
        review.revieweeAccount=Account.findById(revieweeId)
        review.listing=Listing.findById(listingId)
        review.reviewerAccount=rwrAccount
        respond review
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    def createbidder() {
        User user=springSecurityService.currentUser
        Account account=Account.findByUsername(user.username)

        if( Listing.findByHighBidAccount(account) ||
                Listing.findBySellerAccount(account) ){
        }else{ redirect action:"denied", controller:"login"}

        Account rwrAccount= Account.findByUsername(user.username)
        def revieweeId= params.name
        def listingId= params.id


        Review review=new Review(params)
        review.revieweeAccount=Account.findById(revieweeId)
        review.listing=Listing.findById(listingId)
        review.reviewerAccount=rwrAccount
        respond review
    }
    @Secured(["IS_AUTHENTICATED_FULLY"])
    def savebidder(Review reviewInstance) {
        if (reviewInstance == null) {
            notFound()
            return
        }
        if (reviewInstance.hasErrors()) {
            respond reviewInstance.errors, view:'createbidder'
            return
        }
        def reviews = Review.where { revieweeAccount.id==reviewInstance.revieweeAccount.id && reviewerAccount.id==reviewInstance.reviewerAccount.id }.list()
        if( !reviews ){
            reviewInstance.reviewedBidder=true
            reviewInstance.save flush:true
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'review.label', default: 'Review'), reviewInstance.id])
                    redirect reviewInstance
                }
                '*' { respond reviewInstance, [status: CREATED] }
            }
        }else{
            Review review=reviews.first();
            if(review.reviewedBidder==false){
                review.bidderComment = reviewInstance.bidderComment
                review.reviewedBidder = true
                review.save flush:true

                request.withFormat {
                    form multipartForm {
                        flash.message = message(code: 'default.created.message', args: [message(code: 'review.label', default: 'Review'), review.id])
                        redirect review
                    }
                    '*' { respond review, [status: OK] }
                }
            }else{
                flash.error="Cannot create a rate twice for this bidder!"
                respond reviewInstance.errors, view:'createbidder'
                return
            }
        }
    }
    @Secured(["IS_AUTHENTICATED_FULLY"])
    def saveseller(Review reviewInstance) {
        if (reviewInstance == null) {
            notFound()
            return
        }
        if (reviewInstance.hasErrors()) {
            respond reviewInstance.errors, view:'createseller'
            return
        }
        def reviews = Review.where { revieweeAccount.id==reviewInstance.revieweeAccount.id && reviewerAccount.id==reviewInstance.reviewerAccount.id }.list()
        Review review;
        if(!reviews){
            reviewInstance.reviewedSeller=true;
            reviewInstance.save flush:true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'review.label', default: 'Review'), reviewInstance.id])
                    redirect reviewInstance
                }
                '*' { respond reviewInstance, [status: CREATED] }
            }
        }else{
            review=reviews.first()
            if(!review.reviewedSeller){
                review.sellerComment=reviewInstance.sellerComment
                review.reviewedSeller=true
                review.save flush:true
                request.withFormat {
                    form multipartForm {
                        flash.message = message(code: 'default.created.message', args: [message(code: 'review.label', default: 'Review'), review.id])
                        redirect review
                    }
                    '*' { respond review, [status: OK] }
                }
            }
            else{
                flash.error="Cannot create a rate twice for this seller!"
                respond reviewInstance.errors, view:'createseller'
                return
            }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'review.label', default: 'Review'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
