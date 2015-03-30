import groovy.time.TimeCategory
import org.auction.*

class BootStrap {
    def init = { servletContext ->
        def option1,option2,option3;
        def account1, account2;
        def sellerRole, bidderRole
        def user_admin, user_user

   /*     if(!User.count()){
            user_admin = new User(username: 'admin', enabled: true, password: 'admin').save(flush: true)
            user_user = new User(username: 'user', enabled: true, password: 'user').save(flush: true)
        }
        UserRole.create user_admin, adminRole, true  */
        if (!DeliverOption.count()) {
            option1 = new DeliverOption(name: "US Only" ).save(failOnError: true)
            option2 = new DeliverOption(name: "Worldwide" ).save(failOnError: true)
            option3 = new DeliverOption(name: "Pick Up Only" ).save(failOnError: true)
        }
        if (!Listing.count()) {
           /* def listing1 = new Listing(username: "l1",description:"L-1",startDate:new Date()-2,startPrice:0.0,listingDays:1,biddings: null, deliverOption: option1, account: account1  ).save(failOnError: true)
            def listing2 = new Listing(username: "l2",description:"L-2",startDate:new Date() ,startPrice:1.0,listingDays:2,biddings: null,deliverOption: option1, account: account1   ).save(failOnError: true)
            def listing3 = new Listing(username: "l3",description:"L-3",startDate:new Date()-3,startPrice:0.0,listingDays:1,biddings: null,deliverOption: option1, account: account1   ).save(failOnError: true)
            def listing4 = new Listing(username: "l4", description:"L-4",startDate:new Date() ,startPrice:3.0,listingDays:1,biddings: null,deliverOption: option1, account: account1 ).save(failOnError: true)
            def listing5 = new Listing(username: "l5",description:"L-5",startDate:new Date()-1,startPrice:0.0,listingDays:1 ,biddings: null,deliverOption: option1, account: account1  ).save(failOnError: true)
            def listing6 = new Listing(username: "l6",description:"L-6",startDate:new Date() ,startPrice:2.0 ,listingDays:1,biddings: null,deliverOption: option1, account: account1 ).save(failOnError: true)
            def listing7 = new Listing(username: "l7",description:"L-7",startDate:new Date()-2 ,startPrice:4.0 ,listingDays:4 ,biddings: null,deliverOption: option1, account: account1).save(failOnError: true)
            def listing8 = new Listing(username: "l8",description:"L-8",startDate:new Date()-4 ,startPrice:1.0 ,listingDays:1 ,biddings: null,deliverOption: option1, account: account1).save(failOnError: true)
            def listing9 = new Listing(username: "l9", description:"L-9",startDate:new Date(),startPrice:0.0 ,listingDays:2 ,biddings: null,deliverOption: option1, account: account1).save(failOnError: true)
            def listing10 = new Listing(username: "l10",description:"L-10",startDate:new Date() ,startPrice:1.0 ,listingDays:1,biddings: null,deliverOption: option1, account: account1 ).save(failOnError: true)
            def listing11 = new Listing(username: "l11",description:"L-11",startDate:new Date()-5 ,startPrice:0.0 ,listingDays:6,biddings: null ,deliverOption: option1, account: account1).save(failOnError: true)
            def listing12 = new Listing(username: "l12",description:"L-12",startDate:new Date() ,startPrice:1.0,listingDays:2,biddings: null,deliverOption: option1, account: account1   ).save(failOnError: true)
            def listing13 = new Listing(username: "l13",description:"L-13",startDate:new Date()-3,startPrice:0.0,listingDays:1,biddings: null,deliverOption: option1, account: account1   ).save(failOnError: true)
            def listing14 = new Listing(username: "l14", description:"L-14",startDate:new Date() ,startPrice:3.0,listingDays:1,biddings: null,deliverOption: option1, account: account1 ).save(failOnError: true)
            def listing15 = new Listing(username: "l15",description:"L-15",startDate:new Date()-1,startPrice:0.0,listingDays:1 ,biddings: null,deliverOption: option1, account: account1  ).save(failOnError: true)
            def listing16 = new Listing(username: "l16",description:"L-16",startDate:new Date() ,startPrice:2.0 ,listingDays:1,biddings: null,deliverOption: option1, account: account1 ).save(failOnError: true)
            def listing17 = new Listing(username: "l17",description:"L-17",startDate:new Date()-2 ,startPrice:4.0 ,listingDays:4 ,biddings: null,deliverOption: option1, account: account1).save(failOnError: true)
            def listing18 = new Listing(username: "l18",description:"L-18",startDate:new Date()-4 ,startPrice:1.0 ,listingDays:1 ,biddings: null,deliverOption: option1, account: account1).save(failOnError: true)
            def listing19 = new Listing(username: "l19", description:"L-19",startDate:new Date(),startPrice:0.0 ,listingDays:2 ,biddings: null,deliverOption: option1, account: account1).save(failOnError: true)
            def listing20 = new Listing(username: "l20",description:"L-20",startDate:new Date() ,startPrice:1.0 ,listingDays:1,biddings: null,deliverOption: option1, account: account1 ).save(failOnError: true)
            def listing21 = new Listing(username: "l21",description:"L-21",startDate:new Date()-5 ,startPrice:0.0 ,listingDays:6,biddings: null ,deliverOption: option1, account: account1).save(failOnError: true)
*/
        }
    }
    def destroy = {
    }
}
