package org.auction
import geb.Page
class ShowUserPage extends Page {
    static url = "/auction/account/show/"
    static at = { title == "Show Account" }

    static content = {
        header { $("h1") }
        emailLabel { $("#email-label") }
    }
}
