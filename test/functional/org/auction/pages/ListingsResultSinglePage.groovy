package org.auction
import geb.Page

class ListingsResultSinglePage extends Page {
    static url = "/auction/#/listings"
    static at = {
        waitFor {
            $(".listings-header").text() == "Show Listings"
        }
    }

    static content = {
        listingsCompleted {
            waitFor {
                $(".listings-table tbody td:first-child")
            }
        }
    }
}
