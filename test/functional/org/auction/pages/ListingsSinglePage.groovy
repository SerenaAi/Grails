package org.auction
import geb.Page

class ListingsSinglePage extends Page {
    static url = "/auction/#/listings"

    static content = {
        listingsHeader {
            $(".listings-header")
        }
        completeToggle {
            $(".listings-complete-toggle")
        }
        firstListing {
            waitFor {
                $(".listings-table tbody tr:first-child")
            }
        }
    }
}
