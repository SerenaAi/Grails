import groovy.time.TimeCategory
import org.auction.*

class BootStrap {
    def init = { servletContext ->
        def option1,option2,option3;
        def account1, account2, account3;
        def listing1;

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
            def user = new User(
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
        }
    }
}
