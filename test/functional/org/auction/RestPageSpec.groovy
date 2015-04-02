package org.auction
import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class RestPageSpec extends GebReportingSpec {

    @Delegate static HttpUtils httpUtils = new HttpUtils()

    def "Test that we can see all completed listing"() {
        when: "I am sending a GET to retrieve all listings"
            def resp = doGet('api/listings?completed=true')
            assert resp.status == 200
            assert resp.contentType == 'application/json'
            def listing = resp.data

        then: "I am presented with the whole completed listing"
            listing.find { it.name == 'listing 2' }
    }

    def "Test that we can see all the uncompleted listing"() {
        when: "I am sending a GET to retrieve all listings"
            def resp = doGet('api/listings?completed=false')
            assert resp.status == 200
            assert resp.contentType == 'application/json'
            def listing = resp.data

        then: "I am presented with the whole listing"
            listing.find { it.name == 'listing 1' }
    }

    def "Test that we can get all biddings for a particular listing"() {
        when: "I am sending a GET to retrieve all biddings"
            def resp = doGet('api/listings/1/biddings')
            assert resp.status == 200
            assert resp.contentType == 'application/json'
            def biddings = resp.data

        then: "I am presented with the whole listing"
            biddings.find { it.amount == 1.0 }
    }

    def "Test that we can get a particular account"() {
        when: "I am sending a GET to retrieve all biddings"
            def resp = doGet('api/accounts/1')
            assert resp.status == 200
            assert resp.contentType == 'application/json'
            def user = resp.data

        then: "I am presented with the whole listing"
            user.email == 'miao@a.com'
    }

    def "Test that we can't create a bid without authentication"() {
        when: "I am sending a POST to create a bid"
            def resp = doJsonPost('api/biddings', [
                'listing.id': 1,
                'amount': 50,
                'biddingAccount.id': 1
            ])
            def bid = resp.data

        then: "I am presented with an authentication page"
            assert resp.status == 302
    }

    def "Test that we can create a bid"() {
        when: "I am sending a POST to create a bid"
            httpUtils.login('miao', 'miaomiao1')
            def resp = doFormPost('api/biddings', [
                'listing.id': 1,
                'amount': 50,
                'biddingAccount.id': 1
            ])
            def bid = resp.data

        then: "A new bidding is created for the specified listing"
            assert resp.status == 302 // redirect to a 200
    }

    def "Test that we can create a seller feedback"() {
        when: "I am sending a POST to create a comment"
            httpUtils.login('miao', 'miaomiao1')
            def resp = doFormPost('api/reviews', [
                'sellerComment': 'Hello there, nice comment!!!!',
                'revieweeAccount.id': 2,
                'reviewerAccount.id': 1,
                'listing.id': 2
            ])
            def bid = resp.data

        then: "A new comment from the seller is posted"
            assert resp.status == 302 // redirect to a 200
    }

    def "Test that we can create a buyer feedback"() {
        when: "I am sending a POST to create a comment"
            httpUtils.login('chao', 'chaochao1')
            def resp = doFormPost('api/reviews', [
                'sellerComment': 'Hello there, nice comment!!!!',
                'revieweeAccount.id': 2,
                'reviewerAccount.id': 2,
                'listing.id': 2
            ])
            def bid = resp.data

        then: "A new comment from the buyer is posted"
            assert resp.status == 302 // redirect to a 200
    }

    def "Test that we can create a listing with an authenticated user"() {
        when: "I am sending a POST to create a new listing"
            httpUtils.login('chao', 'chaochao1')
            def resp = doFormPost('api/listings', [
                'name': 'NOKIA 20293',
                'description': 'Super Awesome phone made by Nokia',
                'startPrice': 20.23,
                'startDate': 'date.struct',
                'startDate_day': 2,
                'startDate_month': 4,
                'startDate_year': 2015,
                'listingDays': 2,    
                'sellerAccount.id': 2,
                'deliverOption.id': 1
            ])

        then: "A new listing from the logged in user is posted"
            assert resp.status == 302 // redirect to a 200
    }

    def "Test that we can delete a listing owned by the user"() {
        when: "I am sending a DELETE to delete a listing"
            httpUtils.login('chao', 'chaochao1')
            def resp = doDelete('api/listings/1')

        then: "An existing listing is deleted"
            assert resp.status == 200
    }
}
