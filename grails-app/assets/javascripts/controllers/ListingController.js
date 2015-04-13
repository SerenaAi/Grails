app.controller("ListingController", function($scope, Listings, $routeParams, Config){
    var listing={}
    var refresh=function(){
        listing = Listings.get({id:$routeParams.id})
    }
    $scope.getListing=function(){
        return listing
    }
    refresh()
});