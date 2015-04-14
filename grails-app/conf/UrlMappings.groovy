import org.auction.AccountController

class UrlMappings {
    static mappings = {
/*        "/listing/search" {
            controller = "listing"
            action = [POST: "search"]
        }*/

        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }
        "/api/listings"(resources: 'listingRest'){
            "/biddings" (resources: 'biddingRest')
        }
        "/api/biddings"(resources: 'biddingRest')
        "/api/accounts"(resources: 'accountRest')
        "/api/reviews"(resources: 'reviewRest')
        "/api/deliveroptions"(resources:'deliveroptionsRest')
     /*   "/" {
            controller = "login"
            action = "auth"
        }*/
        "/" (view: "/index")
        "500" (view: '/error')
    }
}