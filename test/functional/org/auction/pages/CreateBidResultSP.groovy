package org.auction
import geb.Page

class CreateBidResultSP extends Page {
    static url = "/auction/#/listings/1"
    static at = {
        waitFor {
            $(".bid-create-success").size() == 1
        }
    }

    static content = {}
}
