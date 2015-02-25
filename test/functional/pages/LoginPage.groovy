package pages
import geb.Page

class LoginPage extends Page {

    static url = "/auction/account/index"
    static at = { title == "Login" }

    static content = {
        loginForm { $("form") }
        loginButton { $("input.save", value: "Submit") }
    }
}
