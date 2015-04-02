package org.auction
import geb.Page

class InvalidReviewPage extends Page {
    static url = "/auction/review/createbidder/"

    static content = {
        biddingComment { $("#bidderComment") }
    }
}
