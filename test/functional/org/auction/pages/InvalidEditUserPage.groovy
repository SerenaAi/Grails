package org.auction
import geb.Page
class InvalidEditUserPage extends Page {
    static url = "/auction/account/edit/"
    static content = {
        header { $("h1") }
        emailField { $("#email") }
    }
}
