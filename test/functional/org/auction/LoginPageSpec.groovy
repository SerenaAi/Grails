package org.auction
import geb.spock.GebReportingSpec

class LoginPageSpec extends GebReportingSpec {
    def "Invalid Login"() {
       given: "I am at the login page"
       to LoginPage

       when: "I am entering invalid password"
       loginForm.email = "admin@yahoo.com"
       loginForm.password = "asiaidjd"
       loginButton.click()

       then: "I am being redirected to the login page, the password I entered is wrong"
       at LoginPage
       loginForm.size() == 1
    }
    def "admin login"() {
       given : "I am at the login page"
       to LoginPage

       when: "I am entering valid username and password"
       loginForm.email = "g@g.com"
       loginForm.password = "1aaaaaaa"
       loginButton.click()

       then: "I am being redirected to the user homepage"
       $().text().contains("Show Account")
    }
}
