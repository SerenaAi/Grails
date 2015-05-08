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
    static allowedMethods = [save: "POST"]

    ReviewRestController() {
        super(Review)
    }

    def index(Integer max){
        super.index(max);
    }

    def save() {
        def instance = new Review()
        bindData instance, request

        instance.validate()
        if (instance.hasErrors()) {
            response.status = 404;
            respond status:404, message:"invalid instance"
        }

        def reviews = Review.where {
            reviewerAccount.id == instance.reviewerAccount.id &&
            revieweeAccount.id == instance.revieweeAccount.id
        }.list()

        if (!reviews) {
            if (instance.sellerComment) {
                instance.reviewedSeller = true
            }
            if (instance.bidderComment) {
                instance.reviewedBidder = true
            }
            instance.save flush: true
            respond instance
        } else {
            Review review = reviews.first();
            if (review.reviewedBidder && review.reviewedSeller) {
                response.status = 404;
                respond status:404, message:"cannot review twice"
            }

            //when bidder is not reviewed
            if (!review.reviewedBidder) {
                if (instance.bidderComment) {
                    review.bidderComment = instance.bidderComment
                    review.reviewedBidder = true
                }
            }
            //when seller is not reviewed
            if (!review.reviewedSeller) {
                if ( instance.sellerComment) {
                    review.sellerComment = instance.sellerComment
                    review.reviewedSeller = true
                }
            }
            review.save flush: true
            respond review
        }
    }
}
