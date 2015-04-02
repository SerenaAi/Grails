package org.auction
import geb.spock.GebReportingSpec

class LoginPageSpec extends GebReportingSpec {
    def "Invalid Login"() {
       given: "I am at the login page"
           to LoginPage

       when: "I am entering invalid password"
           loginForm.j_username = "admin@yahoo.com"
           loginForm.j_password = "asiaidjd"
           loginButton.click()

       then: "I am being redirected to the login page, credentials are wrong"
           at LoginPage
           loginForm.size() == 1
    }
    def "admin login"() {
       given : "I am at the login page"
           to LoginPage

       when: "I am entering valid username and password"
           loginForm.j_username = "miao"
           loginForm.j_password = "miaomiao1"
           loginButton.click()

       then: "I am being redirected to the user homepage"
           $().text().contains("Show Account")
    }
    
    def "Test unauthenticated account cannot see profile" () {
        when: "I am attempting to view an account"
            to InvalidShowUserPage
            
        then: "I am being redirected to the denied page"
            at DeniedPage
            errorMsg.size() == 1
    }

    def "Test an authenticated user can see his own profile"() {
        given : "I am at the login page"
            to LoginPage
        when: "I am entering valid username and password for own account"
            loginForm.j_username = "miao"
            loginForm.j_password = "miaomiao1"
            loginButton.click()
            to ShowUserPage, id: 1
        then: "I am being redirected to the user profile"
            at ShowUserPage
            emailLabel.size() == 1
    }

    def "Test unauthenticated account cannot edit profile" () {
        when: "I am attempting to edit an account"
            to InvalidEditUserPage
        then: "I am being redirected to the denied page"
            at LoginPage
            loginForm.size() == 1
    }

    def "Test an authenticated account can edit his own profile" () {
        given : "I am at the login page"
            to LoginPage
        when: "I am entering valid username and password for own account"
            loginForm.j_username = "miao"
            loginForm.j_password = "miaomiao1"
            loginButton.click()
            to EditUserPage, id: 1
        then: "I am being redirected to the edit user profile"
          at EditUserPage
          emailField.size() == 1
    }
}
