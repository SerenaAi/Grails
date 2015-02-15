import org.auction.Account
import org.auction.Listing

class BootStrap {
    def init = { servletContext ->
        if (!Account.count()) {
            def johnDoe = new Account(name: "John", email: "john@yahoo.com", address: "123 Some St", password: "12234334").save(failOnError: true)
            def peteDoe = new Account(name: "Pete", email: "pet@yahoo.com", address: "123 Some St", password: "12234444").save(failOnError: true)
            def sijaDoe = new Account(name: "Siji", email: "siiia@yahoo.com", address: "123 Some St", password: "122344434").save(failOnError: true)
        }
    }
    def destroy = {
    }
}
