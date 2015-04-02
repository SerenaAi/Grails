package org.auction
import geb.Page
class DeniedPage extends Page {
    static url = "/auction/login/denied"
    static at = { title == "Denied" }
    static content = {
        errorMsg { $(".errors") }
    }
}
