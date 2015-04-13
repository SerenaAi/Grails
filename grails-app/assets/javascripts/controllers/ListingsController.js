app.controller("ListingsController", function($scope, Listings, $routeParams){
    var listings={}
    var refresh=function(){
        listings = Listings.query()
    }
    $scope.getListings=function(){
        return listings
    }
    refresh()
});