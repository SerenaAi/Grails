package org.auction
import geb.Page

class LoginPage extends Page {

    static url = "/auction/login/auth"
    static at = { title == "Login" }

    static content = {
        loginForm { $("form") }
        loginButton { $("input#create", value: "Login") }
    }
}
