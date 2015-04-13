package org.auction

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK

class ReviewRestController extends RestfulController<Review> {

    @SuppressWarnings("GroovyUnusedDeclaration")
    static responseFormats = ['json', 'xml']
    def springSecurityService = new SpringSecurityService()
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    ReviewRestController() {
        super(Review)
    }

    @Secured(["IS_AUTHENTICATED_FULLY"])
    @Override
    def save() {
        def user = springSecurityService.currentUser
        def account = Account.findByUsername(user.username)
        int aid = account.id as int

        if (handleReadOnly()) {
            return
        }
        def instance = new Review()
        bindData instance, request
        println instance

        instance.validate()
        if (instance.hasErrors()) {
            respond instance.errors
            return
        }

        def rid = instance.reviewerAccount.id as int
        if (aid != rid) {
            return
        }

        def reviews = Review.where {
            reviewerAccount.id == instance.reviewerAccount.id &&
            revieweeAccount.id == instance.revieweeAccount.id
        }.list()
        if (!reviews) {
            if (instance.sellerComment) {
                instance.reviewedSeller == true
            }
            if (instance.bidderComment) {
                instance.reviewedBidder == true
            }
            instance.save flush: true
            redirect instance
        } else {
            Review review = reviews.first();
            if (review.reviewedBidder && review.reviewedSeller) {
                return
            }
            if (review.reviewedBidder == false) {
                review.bidderComment = instance.bidderComment
                review.reviewedBidder = true
            }
            if (review.reviewedSeller == false) {
                review.sellerComment = instance.sellerComment
                review.reviewedSeller = true
            }
            review.save flush: true
            redirect review
        }
    }
}
