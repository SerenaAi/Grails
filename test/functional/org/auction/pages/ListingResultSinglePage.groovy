package org.auction
import geb.Page

class ListingResultSinglePage extends Page {
    static url = "/auction/#/listings/1"
    static at = {
        waitFor {
            $(".listing-header").text() == "Show Listing"
        }
    }

    static content = {
        listingName {
            waitFor {
                $(".listing-name")
            }
        }
    }
}
