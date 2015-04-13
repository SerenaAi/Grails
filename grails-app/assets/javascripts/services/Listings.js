app.factory('Listings', function($resource) {
    return $resource('/auction/api/listings/:id', {}, {
            save: {
                method: 'PUT'
            }
        }
    )
})