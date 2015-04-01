import groovy.time.TimeCategory
import org.auction.*

class BootStrap {
    def init = { servletContext ->
        def option1,option2,option3;
        def account, user;
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
            user = new User(
                username : 'miao',
                password : 'miaomiao1'
            ).save(failOnError: true, flush: true);

            account = new Account(
                username        : 'miao',
                password        : 'miaomiao1',
                address         : 'miao',
                email           : 'miao@a.com',
                receivedReviews : null,
                sentReviews     : null,
                listings        : null,
                biddings        : null
            ).save(flush: true)

            user = new User(
                username : 'chao',
                password : 'chaochao1'
            ).save(failOnError: true, flush: true);

            account = new Account(
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
    }
}
