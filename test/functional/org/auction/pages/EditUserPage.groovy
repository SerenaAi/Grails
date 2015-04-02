package org.auction
import geb.Page
class EditUserPage extends Page {
    static url = "/auction/account/edit/"
    static at = { title == "Edit Account" }
    static content = {
        header { $("h1") }
        emailField { $("#email") }
    }
}
