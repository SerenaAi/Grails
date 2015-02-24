package org.auction



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BiddingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def show(Bidding biddingInstance) {
        respond biddingInstance
    }

    def create() {
        respond new Bidding(params)
    }

    @Transactional
    def save(Bidding biddingInstance) {


        if (biddingInstance == null) {
            notFound()
            return
        }
        if (biddingInstance.hasErrors()) {
            respond biddingInstance.errors, view:'create'
            return
        }
        Bidding[] bidListing= Listing.findById(biddingInstance.listing.id).biddings as Bidding[];

        def maxAmount=Bidding.createCriteria().get {
            projections {
                max("amount")
            }
        } as Float

        if(maxAmount==null){
            maxAmount=0;
        }else{
            maxAmount+=0.5;
        }
        println "asdfadfa  "+maxAmount

        if(maxAmount <=biddingInstance.amount){
            biddingInstance.save flush:true
        }else{
            redirect biddingInstance
        }
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'bidding.label', default: 'Bidding'), biddingInstance.id])
                    redirect biddingInstance
                }
                '*' { respond biddingInstance, [status: CREATED] }
            }

    }

    def edit(Bidding biddingInstance) {
        respond biddingInstance
    }

    @Transactional
    def update(Bidding biddingInstance) {
        if (biddingInstance == null) {
            notFound()
            return
        }

        if (biddingInstance.hasErrors()) {
            respond biddingInstance.errors, view:'edit'
            return
        }

        biddingInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Bidding.label', default: 'Bidding'), biddingInstance.id])
                redirect biddingInstance
            }
            '*'{ respond biddingInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Bidding biddingInstance) {

        if (biddingInstance == null) {
            notFound()
            return
        }

        biddingInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Bidding.label', default: 'Bidding'), biddingInstance.id])
                redirect controller:"listing", action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bidding.label', default: 'Bidding'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
