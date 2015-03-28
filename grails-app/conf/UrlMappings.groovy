import org.auction.AccountController
import org.auction.AccountRestController

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

        "/api/accounts"(resources: 'accountRest')
        "/api/listings"(resources: 'listingRest'){
            "/biddings" (resources: 'biddingRest')
        }
        "/api/biddings"(resources: 'biddingRest')
        "/" {
            controller = "login"
            action = "auth"
        }
     //   "/" (view: "/index")
        "500" (view: '/error')
    }
}