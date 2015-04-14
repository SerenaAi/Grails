app.factory('Biddings', function($resource) {
    return $resource('/auction/api/biddings/:id', {}, {
        }
    )
})