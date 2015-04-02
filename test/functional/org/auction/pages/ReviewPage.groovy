package org.auction
import geb.Page

class ReviewPage extends Page {
    static url = "/auction/review/createbidder/"
    static at = { title == "Create Review" }

    static content = {
        biddingComment { $("#bidderComment") }
    }
}
