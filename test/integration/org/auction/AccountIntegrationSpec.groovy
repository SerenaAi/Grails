package org.auction

import spock.lang.Specification

class AccountIntegrationSpec extends Specification {

    def ac 
	def setup() {
	}

	def cleanup() {
        ac.delete()
	}

    void "Test creating a new user account into the DB"() { 
        given: 'Account Controller'
        ac = new Account(username: "Peter Pan", address: "123 Some St", email: "x@x.com", password:"99912456z", type: 2).save(failOnError: true)

        when: 'Creating account called'
        ac.create()

        then: 'Checking account exists'
        ac.exists(ac.id)
    }

    void "Test deleting a new user account from the DB"() { 
        given: 'Account Controller'
        ac = new Account(username: "Peter Pan", address: "123 Some St", email: "x@x.com", password:"99912456z", type: 2).save(failOnError: true)

        when: 'Deleting account called'
        ac.delete()

        then: 'Checking account was deleted'
        !ac.exists(ac.id)
    }

}
