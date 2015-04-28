package org.auction
import geb.Page

class SellerFeedbackSP extends Page {
    static url = "/auction/#/listings/1"
    static at = {
        waitFor {
            $(".listing-name").size() == 1
        }
    }

    static content = {
        listingSellerFeedback {
                $(".listing-seller-feedback")
        }
        listingSellerComment {
                $(".listing-seller-comment")
        }
        listingSellerSubmit {
                $(".listing-seller-submit")
        }
    }
}
