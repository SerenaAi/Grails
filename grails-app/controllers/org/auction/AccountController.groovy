package org.auction

import grails.transaction.Transactional
import grails.plugin.springsecurity.*
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import grails.plugin.springsecurity.annotation.Secured

class AccountController {

    def springSecurityService= new SpringSecurityService()
    @Transactional
	def create() {
		respond new Account(params)
	}

    def show() {
        if(springSecurityService?.isLoggedIn()){
            User user= springSecurityService.currentUser;
            Account account= Account.findByUsername(user.username);
            if(!account){
                redirect controller: "login", action:"auth"
            }
            respond account
        }else{
            redirect controller: "login", action:"auth"
        }
    }

	@Transactional
	def save(Account accountInstance) {
		if (accountInstance == null) {
			notFound()
			return
		}
        if (accountInstance.hasErrors()) {
            respond accountInstance.errors, view:'create'
            return
        }

        User user = new User(username:accountInstance.username, password: accountInstance.password)
        user.id=accountInstance.id
        if (!accountInstance.validate() || !user.validate()) {
            flash.error = "The username or email is already exist!"
            redirect action: "create", controller:"account"
        }else{
            accountInstance.save flush:true
            user.save flush:true
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'account.label', default: 'Account'), accountInstance.id])
                    redirect controller:"login",action:"auth"
                }
                '*' { respond accountInstance, [status: CREATED] }
            }
        }
	}

    @Secured(["IS_AUTHENTICATED_FULLY"])
	def edit() {
        if(springSecurityService.isLoggedIn()){
            User user= springSecurityService.currentUser;
            Account account= Account.findByUsername(user.username);
            if(!account){
                redirect controller: "login", action:"auth"
            }
            respond account
        }else{
            redirect controller: "login", action:"auth"
        }
	}

	@Transactional
	def update(Account accountInstance) {
		if (accountInstance == null) {
			notFound()
			return
		}
		if (accountInstance.hasErrors()) {
			respond accountInstance.errors, view:'edit'
			return
		}

        User user= springSecurityService.currentUser;
        user.username =accountInstance.username;
        user.password=accountInstance.password;
        if (!accountInstance.validate() || !user.validate()) {
            flash.error = "The username or email is already exist!"
            redirect action: "create", controller:"account"
        }else{
            accountInstance.save flush:true
            user.save flush:true
            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'account.label', default: 'Account'), accountInstance.id])
                    redirect controller:"login",action:"auth"
                }
                '*' { respond accountInstance, [status: CREATED] }
            }
        }
	}

    @Secured(["IS_AUTHENTICATED_FULLY"])
	def delete() {
        User user= springSecurityService.currentUser;
        Account accountInstance= Account.findByUsername(user.username);
		if (accountInstance == null) {
			notFound()
			return
		}

        Collection<UserRole> userRoles = UserRole.findAllByUser(user);
        userRoles*.delete()
        user.delete()
		accountInstance.delete flush:true

		redirect controller:"logout", method: "POST"
	}
	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'account.label', default: 'Account'), params.id])
				redirect action: "auth", controller:"login", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
