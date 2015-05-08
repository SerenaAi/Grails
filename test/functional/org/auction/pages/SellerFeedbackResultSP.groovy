package org.auction
import geb.Page

class SellerFeedbackResultSP extends Page {
    static url = "/auction/#/reviews/1"
    static at = {
        waitFor {
            $(".review-seller-comment").size() == 1
        }
    }

    static content = {}
}
