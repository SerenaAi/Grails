app.factory('Biddings', function($resource) {
    return $resource('/auction/api/listings/:id/biddings', {}, {
        }
    )
})