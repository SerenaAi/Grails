app.factory('Options',function($resource) {
    return $resource('/auction/api/deliveroptions/:id', {}, {
            save: {
                method: 'PUT'
            }
        }
    )
})