package org.auction



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BidderAccountController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BidderAccount.list(params), model:[bidderAccountInstanceCount: BidderAccount.count()]
    }

    def show(BidderAccount bidderAccountInstance) {
        respond bidderAccountInstance
    }

    def create() {
        respond new BidderAccount(params)
    }

    @Transactional
    def save(BidderAccount bidderAccountInstance) {
        if (bidderAccountInstance == null) {
            notFound()
            return
        }

        if (bidderAccountInstance.hasErrors()) {
            respond bidderAccountInstance.errors, view:'create'
            return
        }

        bidderAccountInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bidderAccount.label', default: 'BidderAccount'), bidderAccountInstance.id])
                redirect bidderAccountInstance
            }
            '*' { respond bidderAccountInstance, [status: CREATED] }
        }
    }

    def edit(BidderAccount bidderAccountInstance) {
        respond bidderAccountInstance
    }

    @Transactional
    def update(BidderAccount bidderAccountInstance) {
        if (bidderAccountInstance == null) {
            notFound()
            return
        }

        if (bidderAccountInstance.hasErrors()) {
            respond bidderAccountInstance.errors, view:'edit'
            return
        }

        bidderAccountInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BidderAccount.label', default: 'BidderAccount'), bidderAccountInstance.id])
                redirect bidderAccountInstance
            }
            '*'{ respond bidderAccountInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BidderAccount bidderAccountInstance) {

        if (bidderAccountInstance == null) {
            notFound()
            return
        }

        bidderAccountInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BidderAccount.label', default: 'BidderAccount'), bidderAccountInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bidderAccount.label', default: 'BidderAccount'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
