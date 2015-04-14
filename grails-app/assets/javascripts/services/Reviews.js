app.factory('Reviews', function($resource) {
    return $resource('/auction/api/reviews/:id', {}, {
        }
    )
})