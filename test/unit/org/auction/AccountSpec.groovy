package org.auction

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Account)
class AccountSpec extends Specification {
    def setup() {
    }
    def cleanup() {
    }
    void "test when all account fields are invalid"() {
        //all invalid:
        setup:
            def count=Account.count()
        when:
            Account account=new Account(name:null, email:null, address: null, password: null)
            account.save();
        then:
            Account.count()==count
    }
    void "test when all account fields are valid"() {
        //all valid:
        setup:
            def count=Account.count()
        when:
            Account account=new Account(name:"a", email:"a@a.com", address: "a", password: "1aaaaaaa")
            account.save();
        then:
            Account.count()==count+1
    }
    void "test when password has no number"() {
        //all valid:
        setup:
            def count=Account.count()
        when:
            Account account=new Account(name:"a", email:"a@a.com", address: "a", password: "aaaaaaaa")
            account.save(failOnError: true);
        then:
            count==Account.count()
            thrown(grails.validation.ValidationException)
    }
    void "test when password has no letter"() {
        //all valid:
        setup:
            def count=Account.count()
        when:
            Account account=new Account(name:"a", email:"a@a.com", address: "a", password: "11111111")
            account.save(failOnError: true);
        then:
            count==Account.count()
            thrown(grails.validation.ValidationException)
    }
    void "test when password length is invalid"() {
        //all valid:
        setup:
        def count=Account.count()
        when:
        Account account=new Account(name:"a", email:"a@a.com", address: "a", password: "1aaaaaa")
        account.save(failOnError: true);
        then:
        count==Account.count()
        thrown(grails.validation.ValidationException)
    }
    void "test when email format is invalid"() {
        //all valid:
        setup:
        def count=Account.count()
        when:
        Account account=new Account(name:"a", email:"a.com", address: "a", password: "1aaaaaa")
        account.save(failOnError: true);
        then:
        count==Account.count()
        thrown(grails.validation.ValidationException)
    }
}
