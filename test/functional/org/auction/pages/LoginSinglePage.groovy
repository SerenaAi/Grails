package org.auction
import geb.Page

class LoginSinglePage extends Page {
    static url = "/auction/#/home"
    static at = {
        waitFor {
            $(".login-submit").size() == 1
        }
    }

    static content = {
        loginUsername {
            $(".login-username")
        }
        loginPassword {
            $(".login-password")
        }
        loginSubmit {
            $(".login-submit")
        }
        loginSuccess {
            $(".login-success")
        }
        loginFail {
            $(".login-fail")
        }
    }
}
