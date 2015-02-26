package org.auction

import geb.Page
import geb.spock.GebReportingSpec
import pages.*

class LoginPageSpec extends GebReportingSpec {
    def "invalid login"() {
       given: "I am at the login page"
       to LoginPage

       when: "I am entering invalid password"
       loginForm.email = "admin"
       loginForm.password = "ioguffwf"
       loginButton.click()

       then: "I am being redirected to the login page, the password I entered is wrong"
       at LoginPage
       loginForm.email == "admin"
       !loginForm.password
    }
    
    def "admin login"() {
       given : "I am at the login page"
       to LoginPage

       when: "I am entering valid username and password"
       loginForm.email = "g@g.com"
       loginForm.password = "a111111"
       loginButton.click()

       then: "I am being redirected to the user homepage"
       at LoginPage 
       $().text().contains("Show Account")
    }
}
