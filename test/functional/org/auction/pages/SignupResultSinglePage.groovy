package org.auction
import geb.Page

class SignupResultSinglePage extends Page {
    static url = "/auction/#/home"
    static at = {
        waitFor {
            $(".signup-success").size() == 1
        }
    }

    static content = {}
}
