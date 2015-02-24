import groovy.time.TimeCategory

import org.auction.Account
import org.auction.DeliverOption
import org.auction.Listing

class BootStrap {
    def init = { servletContext ->
        if (!Account.count()) {
            def account1= new Account(name: "Sijia",address: "aaa st",email:"a@a.com",password:"xxxxxxxx", type:1 ).save(failOnError: true)
            def account2= new Account(name: "Gerar",address: "gg st",email:"g@g.com",password: "aaaaaaaa",type:2 ).save(failOnError: true)
        }
        if (!DeliverOption.count()) {
            def option1 = new DeliverOption(name: "US Only",id:1 ).save(failOnError: true)
            def option2 = new DeliverOption(name: "Worldwide", id:2 ).save(failOnError: true)
            def option3 = new DeliverOption(name: "Pick Up Only", id:3 ).save(failOnError: true)
        }
        if (!Listing.count()) {
            // def list1 = new Listing(name: "Laptop Vaio", description: "Awesome laptop", startDate:new Date() ,startPrice:90.50, listingDays:1, createdDate: new Date(), account: 1,         ).save(failOnError: true)
        }
    }
    def destroy = {
    }
}
