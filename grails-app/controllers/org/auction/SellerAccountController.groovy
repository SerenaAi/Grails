package org.auction



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SellerAccountController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SellerAccount.list(params), model:[sellerAccountInstanceCount: SellerAccount.count()]
    }

    def show(SellerAccount sellerAccountInstance) {
        respond sellerAccountInstance
    }

    def create() {
        respond new SellerAccount(params)
    }

    @Transactional
    def save(SellerAccount sellerAccountInstance) {
        if (sellerAccountInstance == null) {
            notFound()
            return
        }

        if (sellerAccountInstance.hasErrors()) {
            respond sellerAccountInstance.errors, view:'create'
            return
        }

        sellerAccountInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sellerAccount.label', default: 'SellerAccount'), sellerAccountInstance.id])
                redirect sellerAccountInstance
            }
            '*' { respond sellerAccountInstance, [status: CREATED] }
        }
    }

    def edit(SellerAccount sellerAccountInstance) {
        respond sellerAccountInstance
    }

    @Transactional
    def update(SellerAccount sellerAccountInstance) {
        if (sellerAccountInstance == null) {
            notFound()
            return
        }

        if (sellerAccountInstance.hasErrors()) {
            respond sellerAccountInstance.errors, view:'edit'
            return
        }

        sellerAccountInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SellerAccount.label', default: 'SellerAccount'), sellerAccountInstance.id])
                redirect sellerAccountInstance
            }
            '*'{ respond sellerAccountInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SellerAccount sellerAccountInstance) {

        if (sellerAccountInstance == null) {
            notFound()
            return
        }

        sellerAccountInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SellerAccount.label', default: 'SellerAccount'), sellerAccountInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sellerAccount.label', default: 'SellerAccount'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
