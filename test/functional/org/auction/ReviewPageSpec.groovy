package org.auction
import geb.spock.GebReportingSpec

class ReviewPageSpec extends GebReportingSpec {

    def "Test that only seller can provide review feedback"() {
       when: "I am entering the listing as a seller"
            to LoginPage
            loginForm.j_username = "miao"
            loginForm.j_password = "miaomiao1"
            loginButton.click()
            to ReviewPage, id: 2, name: 2
       then: "I am being redirected to review bidder page"
           at ReviewPage
           biddingComment.size() == 1
    }

    def "Test that only winners can provide review feedback"() {
       when: "I am entering the listing as the winner of the bid"
            to LoginPage
            loginForm.j_username = "miao"
            loginForm.j_password = "miaomiao1"
            loginButton.click()
            to ReviewPage, id: 2, name: 1
       then: "I am being redirected to review bidder page"
           at ReviewPage
           biddingComment.size() == 1
    }

    def "Test that a non bid winner can't provide feedback"() {
       when: "I am entering the listing as a non winner of the bid"
            to LoginPage
            loginForm.j_username = "chao"
            loginForm.j_password = "chaochao1"
            loginButton.click()
            to InvalidReviewPage, id: 2, name: 1
       then: "I am being redirected to review bidder page"
            at DeniedPage
            errorMsg.size() == 1
    }

    def "Test that a non bid seller can't provide feedback"() {
       when: "I am entering the listing as a non seller of the bid"
            to LoginPage
            loginForm.j_username = "chao"
            loginForm.j_password = "chaochao1"
            loginButton.click()
            to InvalidReviewPage, id: 2, name: 2
       then: "I am being redirected to review bidder page"
            at DeniedPage
            errorMsg.size() == 1
    }
}
