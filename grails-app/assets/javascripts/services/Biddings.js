app.factory('Biddings', function($resource) {
    return $resource('/auction/api/listings/:id/biddings', {}, {
        }
    )
})

app.factory('Bidding', function($resource) {
    return $resource('/auction/api/biddings/:id', {}, {
        }
    )
})