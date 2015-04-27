package org.auction
import geb.Page

class CreateListingSP extends Page {
    static url = "/auction/#/listings/create"
    static at = {
        waitFor {
            $(".listing-submit").size() == 1
        }
    }

    static content = {
        listingName {
            $(".listing-name")
        }
        listingDesc {
            $(".listing-desc")
        }
        listingPrice {
            $(".listing-price")
        }
        listingDate {
            $(".listing-date")
        }
        listingDays {
            $(".listing-days")
        }
        listingDeliveryToggle {
            $(".listing-delivery-toggle")
        }
        listingDelivery {
            waitFor {
                $(".listing-delivery").first()
            }
        }
        listingSubmit {
            $(".listing-submit")
        }
    }
}
