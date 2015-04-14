app.controller("ListingController", function($scope, Listings, $routeParams){
    var listing={}
    var refresh=function(){
        listing = Listings.get({id: $routeParams.id})
    }
    $scope.getListing=function(){
        return listing
    }
    $scope.getListingID=function(){
        return $routeParams.id
    }
    refresh()
})