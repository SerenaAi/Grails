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

     /*   "/" {
            controller = "login"
            action = "auth"
        }*/
        "/" (view: "/index")
        "500" (view: '/error')
    }
}