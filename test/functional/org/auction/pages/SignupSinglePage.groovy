package org.auction
import geb.Page

class SignupSinglePage extends Page {
    static url = "/auction/#/accounts/create"

    static content = {
        signupEmail {
            waitFor {
                $(".signup-email")
            }
        }
        signupPassword {
            waitFor {
                $(".signup-password")
            }
        }
        signupUsername {
            waitFor {
                $(".signup-username")
            }
        }
        signupAddress {
            waitFor {
                $(".signup-address")
            }
        }
        signupSubmit {
            waitFor {
                $(".signup-submit")
            }
        }
        signupSuccess {
            $(".signup-success")
        }
        signupFail {
            $(".signup-fail")
        }
    }
}
