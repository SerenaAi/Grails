package org.auction
import geb.spock.GebReportingSpec

class SinglePageSpec extends GebReportingSpec {

    def "Test that we can display only completed listings" () {
        when: "I am entering the listing page without being logged in"
            to ListingsSinglePage
            completeToggle.click()

        then: "Complete listings are diplayed"
            at ListingsResultSinglePage
            listingsCompleted.text().contains("true")
    }

    def "Test that we can list details for a particular listing" () {
        when: "I am entering a specific listing details page"
            to ListingSinglePage

        then: "Complete listings are diplayed"
            at ListingSinglePage
            listingName.text().contains("listing 1")
            listingDesc.text().contains("listing 1 description")
            listingDays.text().contains("1")
    }
}
