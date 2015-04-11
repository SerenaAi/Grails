app.controller("ListingController", ['$scope','RestService',function($scope, RestService){
    $scope.getData=function(){
        RestService.listings()._get({}, function (data) {
            console.log(data);
        });
    }
    $scope.getData();
}]);