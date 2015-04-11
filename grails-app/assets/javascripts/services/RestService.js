app.factory('RestService', ['$resource', function ($resource) {
    var restService = {};
    var path = '/auction/api/';
    restService.listings = function () {
        return $resource(path + 'listings', {}, {
            _get: { method: 'GET', cache: true, isArray: true },
            _put: { method: 'PUT' },
            _post: { method: 'POST' },
            _delete: { method: 'DELETE'}
        });
    }
    return restService;
}]);