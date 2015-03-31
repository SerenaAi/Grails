package org.auction

import geb.spock.GebReportingSpec

class ListingPageSpec extends GebReportingSpec {
    def "Test that only logged in users can add a new listing"() {
       when: "I am entering the listing page without being logged in"
           to ListingPage

       then: "I am being redirected to the login page"
           at LoginPage
           loginForm.size() == 1
    }

    def "Test that when a listing is created, the logged in user is set as the seller"() {
        when:
            to LoginPage
            loginForm.j_username = "miao"
            loginForm.j_password = "miaomiao1"
            loginButton.click()

            to ListingPage
            listForm.name = "Banana"
            listForm.description = "Creamy Banana"
            listForm.startPrice = "32.34"
            listForm.listingDays = "4"
            saveButton.click()

        then:
            $().text().contains("miao")
    }
}
