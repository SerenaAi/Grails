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
            waitFor {
                $(".listing-bidder-feedback")
            }
        }
        listingBidderComment {
            waitFor {
                $(".listing-bidder-comment")
            }
        }
        listingBidderSubmit {
            waitFor {
                $(".listing-bidder-submit")
            }
        }
    }
}
