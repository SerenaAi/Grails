package org.auction



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DeliverOptionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DeliverOption.list(params), model:[deliverOptionInstanceCount: DeliverOption.count()]
    }

    def show(DeliverOption deliverOptionInstance) {
        respond deliverOptionInstance
    }

    def create() {
        respond new DeliverOption(params)
    }

    @Transactional
    def save(DeliverOption deliverOptionInstance) {
        if (deliverOptionInstance == null) {
            notFound()
            return
        }

        if (deliverOptionInstance.hasErrors()) {
            respond deliverOptionInstance.errors, view:'create'
            return
        }

        deliverOptionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'deliverOption.label', default: 'DeliverOption'), deliverOptionInstance.id])
                redirect deliverOptionInstance
            }
            '*' { respond deliverOptionInstance, [status: CREATED] }
        }
    }

    def edit(DeliverOption deliverOptionInstance) {
        respond deliverOptionInstance
    }

    @Transactional
    def update(DeliverOption deliverOptionInstance) {
        if (deliverOptionInstance == null) {
            notFound()
            return
        }

        if (deliverOptionInstance.hasErrors()) {
            respond deliverOptionInstance.errors, view:'edit'
            return
        }

        deliverOptionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DeliverOption.label', default: 'DeliverOption'), deliverOptionInstance.id])
                redirect deliverOptionInstance
            }
            '*'{ respond deliverOptionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DeliverOption deliverOptionInstance) {

        if (deliverOptionInstance == null) {
            notFound()
            return
        }

        deliverOptionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DeliverOption.label', default: 'DeliverOption'), deliverOptionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'deliverOption.label', default: 'DeliverOption'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
