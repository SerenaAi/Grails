package org.auction
import geb.Page

class CreateBidPage extends Page {

    static url = "/auction/bidding/create/"
    static at = { title == "Create Bidding" }

    static content = {
        bidForm { $("form") } 
        amountField { $("#amount") }
        createButton { $("#create") }
    }
}
