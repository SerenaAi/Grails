import groovy.time.TimeCategory
import org.auction.*

class BootStrap {
    def init = { servletContext ->
        def option1,option2,option3;
        def account1;

        if (!Account.count()) {
            def user = new User(
                username : 'miao',
                password : 'miaomiao1'
            ).save(flush: true);

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
        }
 
        if (!DeliverOption.count()) {
            option1 = new DeliverOption(
                name: "US Only"
            ).save(failOnError: true)
            option2 = new DeliverOption(
                name: "Worldwide"
            ).save(failOnError: true)
            option3 = new DeliverOption(
                name: "Pick Up Only"
            ).save(failOnError: true)
        }
        if (!Listing.count()) {
          // def listing1 = new Listing(
          //     username: "l1",
          //     description: "L-1",
          //     startDate: new Date() - 2,
          //     startPrice: 0.0,
          //     listingDays: 1,
          //     biddings: null,
          //     deliverOption: option1,
          //     account: account1
          // ).save(failOnError: true)
          // def listing2 = new Listing(
          //     username: "l2",
          //     description: "L-2",
          //     startDate: new Date(),
          //     startPrice: 1.0,
          //     listingDays: 2,
          //     biddings: null,
          //     deliverOption: option1,
          //     account: account1
          // ).save(failOnError: true)
          // def listing3 = new Listing(
          //     username: "l3",
          //     description: "L-3",
          //     startDate: new Date() - 3,
          //     startPrice: 0.0,
          //     listingDays: 1,
          //     biddings: null,
          //     deliverOption: option1,
          //     account: account1
          // ).save(failOnError: true)
          // def listing4 = new Listing(
          //     username: "l4",
          //     description: "L-4",
          //     startDate: new Date(),
          //     startPrice: 3.0,
          //     listingDays: 1,
          //     biddings: null,
          //     deliverOption: option1,
          //     account: account1
          // ).save(failOnError: true)
          // def listing5 = new Listing(
          //     username: "l5",
          //     description: "L-5",
          //     startDate: new Date() - 1,
          //     startPrice: 0.0,
          //     listingDays: 1,
          //     biddings: null,
          //     deliverOption: option1,
          //     account: account1
          // ).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
