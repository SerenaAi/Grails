package org.auction
import geb.Page

class SignupSinglePage extends Page {
    static url = "/auction/#/accounts/create"

    static content = {
        signupEmail {
            $(".signup-email")
        }
        signupPassword {
            $(".signup-password")
        }
        signupUsername {
            $(".signup-username")
        }
        signupAddress {
            $(".signup-address")
        }
        signupSubmit {
            $(".signup-submit")
        }
        signupSuccess {
            $(".signup-success")
        }
        signupFail {
            $(".signup-fail")
        }
    }
}
