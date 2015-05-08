package org.auction
import geb.Page

class CreateListingResultSP extends Page {
    static url = "/auction/#/listings"
    static at = {
        waitFor {
            $(".listing-create-success").size() == 1
        }
    }

    static content = {}
}
