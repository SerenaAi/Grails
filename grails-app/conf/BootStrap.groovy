import groovy.time.TimeCategory
import org.auction.*

class BootStrap {
    def init = { servletContext ->
        def option1,option2,option3
        def account1,account2,user1,user2
        def listing1,listing2
        def bidding1,bidding2,bidding3

        if (!DeliverOption.count()) {
            option1 = new DeliverOption(
                name: "US Only"
            ).save(failOnError: true, flush: true);
            option2 = new DeliverOption(
                name: "Worldwide"
            ).save(failOnError: true, flush: true);
            option3 = new DeliverOption(
                name: "Pick Up Only"
            ).save(failOnError: true, flush: true);
        }

        if (!Account.count()) {
            user1 = new User(
                username : 'miao',
                password : 'miaomiao1'
            ).save(failOnError: true, flush: true);

            account1 = new Account(
                username        : 'miao',
                password        : 'miaomiao1',
                address         : 'miao',
                email           : 'miao@a.com',
                receivedReviews : null,
                sentReviews     : null,
                listings        : null,
                biddings        : null
            ).save(flush: true)

            user2 = new User(
                username : 'chao',
                password : 'chaochao1'
            ).save(failOnError: true, flush: true);

            account2 = new Account(
                username        : 'chao',
                password        : 'chaochao1',
                address         : 'chao',
                email           : 'chao@a.com',
                receivedReviews : null,
                sentReviews     : null,
                listings        : null,
                biddings        : null
            ).save(flush: true)
        }
        if (!Listing.count()) {
            listing1 = new Listing(
                    description: 'listing 1 description',
                    name: 'listing 1',
                    listingDays: 1,
                    startPrice: 0,
                    startDate: new Date(),
                    sellerAccount: account1,
                    deliverOption: option1
            ).save(failOnError: true, flush: true);

            listing2 = new Listing(
                    description: 'listing 2 description',
                    name: 'listing 2',
                    listingDays: 1,
                    startPrice: 0,
                    startDate: new Date()-3,
                    sellerAccount: account1,
                    deliverOption: option1
            ).save(failOnError: true, flush: true);
        }

        if (!Bidding.count()) {
            bidding1 = new Bidding(
                    amount: 1,
                    biddingAccount: account2,
                    listing: listing1
            ).save(failOnError: true, flush: true);

            bidding2 = new Bidding(
                    amount: 2,
                    biddingAccount: account1,
                    listing: listing2
            ).save(failOnError: true, flush: true);

            bidding3 = new Bidding(
                    amount: 3,
                    biddingAccount: account2,
                    listing: listing2
            ).save(failOnError: true, flush: true);
        }
    }
}
