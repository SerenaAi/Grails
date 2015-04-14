app.factory('Listings', function($resource) {
    return $resource('/auction/api/listings/:id', {}, {
            get:{method:'GET'},
            select:{method:'GET', isArray: true}
        }
    )
})