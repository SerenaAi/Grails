package org.auction
import geb.Page

class ListingPage extends Page {
    static url = "/auction/listing/create"

    static content = {
        listForm { $("form") }
        saveButton { $("input#create", value: "Create") }
    }
}
