app.controller("ListingController", function($scope, Listings, Auth, $routeParams, $rootScope, $location){
    var listing={}
    var sellerAccount
    //get detail listing
    var refresh=function(){
        Listings.get({id: $routeParams.id},function(data){
            listing=data
            sellerAccount=listing.sellerAccount.id
            $scope.listingName=listing.name
            $scope.description=listing.description
            $scope.startPrice=listing.startPrice
            $scope.listingDays=listing.listingDays
            $scope.option=listing.deliverOption.id
            $rootScope.$broadcast("readOptionName",{currentOption: $scope.option})
        })
    }
    $scope.getListing=function(){
        return listing
    }
    $scope.setOption=function(id){
        $scope.option=id;
    }
    $scope.getListingID=function(){
        return $routeParams.id
    }
    $scope.editListing=function(){
        if(Auth.account!=null && Auth.account!=undefined && Auth.account.id==sellerAccount){
            var newListing={
                'name':$scope.listingName,
                'description': $scope.description,
                'startPrice':parseInt($scope.startPrice),
                'listingDays':parseInt($scope.listingDays),
                'startDate_day':1,
                'startDate_month':5,
                'startDate_year':2015,
                'startDate':'date.struct',
                'sellerAccount':parseInt(Auth.account.id),
                'deliverOption':parseInt($scope.option)
            }
            $id= $routeParams.id
            Listings.update({id: $id}, newListing, function(){
                refresh()
                $location.path( 'listings/'+$routeParams.id)
            })
        }
    }
    refresh()
})