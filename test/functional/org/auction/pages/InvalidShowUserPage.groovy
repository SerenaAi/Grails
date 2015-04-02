package org.auction
import geb.Page
class InvalidShowUserPage extends Page {
    static url = "/auction/account/show/"
    static content = {
        header { $("h1") }
        emailLabel { $("#email-label") }
    }
}
