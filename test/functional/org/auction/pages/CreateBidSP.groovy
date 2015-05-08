package org.auction
import geb.Page

class CreateBidSP extends Page {
    static url = "/auction/#/listings/bidding/1"
    static at = {
        waitFor {
            $(".bid-create-submit").size() == 1
        }
    }

    static content = {
        bidAmount {
            $(".bid-create-amount")
        }
        bidSubmit {
            $(".bid-create-submit")
        }
    }
}
