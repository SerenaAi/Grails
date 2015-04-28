package org.auction
import geb.Page

class BidderFeedbackResultSP extends Page {
    static url = "/auction/#/reviews/1"
    static at = {
        waitFor {
            $(".review-bidder-comment").size() == 1
        }
    }

    static content = {}
}
