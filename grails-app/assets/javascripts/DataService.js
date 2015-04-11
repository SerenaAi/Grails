angular.module('app').factory('RestService', ['$resource', function ($resource) {
    var restService = {};
    var path = '/api/';
    restService.request = function (url) {
        return $resource(path + 'app', {}, {
            _get: { method: 'GET', cache: true, isArray: true },
            _put: { method: 'PUT' },
            _post: { method: 'POST' },
            _delete: { method: 'DELETE'}
        });
    }
    return restService;
}]);
