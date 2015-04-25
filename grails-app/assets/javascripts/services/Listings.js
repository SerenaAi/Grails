app.factory('Listings', function($resource) {
    return $resource('/auction/api/listings/:id', {}, {
            'select':{method:'GET', isArray: true},
            'update':{method: 'PUT'}
        }
    )
})