package org.auction
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class SinglePageSpec extends GebReportingSpec {

    def "Test that we can display only completed listings" () {
        when: "I am entering the listing page"
            to ListingsSinglePage
            completeToggle.click()

        then: "Complete listings are diplayed"
            at ListingsResultSinglePage
            listingsCompleted.text().contains("true")
    }

    def "Test that we can list details for a particular listing" () {
        when: "I am entering the listing page"
            to ListingsSinglePage
            firstListing.click()

        then: "Complete listings are diplayed"
            at ListingResultSinglePage
            waitFor {
                listingName.text().contains("listing 1")
            }
    }

    def "Test that a user successfully login" () {
        when: "I am entering the home page"
            to LoginSinglePage
            loginUsername = "miao"
            loginPassword = "miaomiao1"
            loginSubmit.click();

        then: "Ensure user successfully access"
            at LoginSinglePage
            waitFor {
                loginSuccess.size() == 1
            }
    }

    def "Test that a user fails to login" () {
        when: "I am entering the home page"
            to LoginSinglePage
            loginUsername = "asd"
            loginPassword = "asdfdf34"
            loginSubmit.click();

        then: "Ensure user fails to access"
            at LoginSinglePage
            waitFor {
                loginFail.size() == 1
            }
    }

    def "Test that a new user can create an account" () {
        when: "I am entering new user data"
            to SignupSinglePage
            signupEmail = "hao@yahoo.com"
            signupPassword = "haohao241"
            signupUsername = "hao"
            signupAddress = "Hao St 123"
            signupSubmit.click();

        then: "Ensure user creates an account"
            at SignupResultSinglePage
    }

    def "Test that a new listing can be created" () {
        when: "I am entering new listing data"
            to LoginSinglePage
            loginUsername = "miao"
            loginPassword = "miaomiao1"
            loginSubmit.click();

            to CreateListingSP
            listingName = "listing 3"
            listingDesc = "awesome listing 3"
            listingPrice = "35.90"
            listingDate = "2015-05-20"
            listingDays = "2"
            listingDeliveryToggle.click();
            listingDelivery.click()
            listingSubmit.click()
            
        then: "Ensure user creates an account"
            at CreateListingResultSP
    }

    def "Test that a user can create a bid on a listing" () {
        when: "I am logging in and creating a bid for a listing"
            to LoginSinglePage
            loginUsername = "miao"
            loginPassword = "miaomiao1"
            loginSubmit.click();

            to CreateBidSP
            bidAmount = "29"
            bidSubmit.click()            

        then: "Ensure user creates a bidding for a listing"
            at CreateBidResultSP
    }

    def "Test that a user can leave feedback to a seller" () {
        when: "I am logging in and adding a commenr for a seller"
            to LoginSinglePage
            loginUsername = "miao"
            loginPassword = "miaomiao1"
            loginSubmit.click();

            to SellerFeedbackSP
            listingSellerFeedback.click()
            listingSellerComment = "Posting comments to seller!"
            listingSellerSubmit.click()           

        then: "Ensure user leaves a comment  on a seller listing"
            to SellerFeedbackResultSP
    }
}
