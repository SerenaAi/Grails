package org.auction
import geb.Page

class ListingSinglePage extends Page {
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
        listingDesc {
            waitFor {
                $(".listing-desc")
            }
        }
        listingDays {
            waitFor {
                $(".listing-days")
            }
        }
    }
}
