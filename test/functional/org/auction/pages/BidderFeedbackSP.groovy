package org.auction
import geb.Page

class BidderFeedbackSP extends Page {
    static url = "/auction/#/listings/1"
    static at = {
        waitFor {
            $(".listing-name").size() == 1
        }
    }

    static content = {
        listingBidderFeedback {
                $(".listing-bidder-feedback")
        }
        listingBidderComment {
                $(".listing-bidder-comment")
        }
        listingBidderSubmit {
                $(".listing-bidder-submit")
        }
    }
}
