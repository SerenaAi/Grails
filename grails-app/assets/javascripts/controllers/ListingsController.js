app.controller("ListingsController", function($scope, Listings, $routeParams, $location, Auth){
    var listings={}
    var completed=false;
    $scope.button="Show Completed"

    var refresh=function(){
        if(completed==false){
            listings = Listings.query()
        }else{
            listings = Listings.select({completed:true})
        }
    }

    $scope.completedSwitch=function(){
        if(completed==false) {
            completed=true
            $scope.button="Show All"
        }
        else {
            completed=false
            $scope.button="Show Completed"
        }
        refresh()
    }

    $scope.getListings=function(){
        return listings
    }

    $scope.setOption=function(id){
        $scope.option=id;
    }

    //create listing
    $scope.saveListing = function () {
        if(Auth.account!=null && Auth.account!=undefined){
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
            Listings.save(newListing, function(){
                refresh()
                $location.path( 'listings')
            })
        }else{
            alert("please login first")
        }
    }

    //delete listing
    $scope.deleteListing = function () {
            Listings.delete({id: $routeParams.id },function(){
                refresh()
                $location.path( 'listings')
            })
    }

    refresh()
});