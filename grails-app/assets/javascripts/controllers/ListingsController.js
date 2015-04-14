app.controller("ListingsController", function($scope, Listings, $routeParams){
    var listings={}
    var completed=false;
    $scope.button="Show Completed"
    $scope.newlisting={
        name:'aa',
        description:'1111',
        startPrice:1,
        listingDays:1,
        startDate_day:1,
        startDate_month:5,
        startDate_year:2015,
        startDate:'date.struct',
        sellerAccount:1,
        deliverOption:1
    }

    var refresh=function(){
        if(completed==false){
            listings = Listings.query()
        }else if(completed==true){
            listings = Listings.select({completed:true})
        }else{
            return null
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

    //create listing
    $scope.saveListing = function () {
        Listings.save($scope.newlisting).$promise.then(function(){
            alert("arrr");
            refresh()
        })
    }
    refresh()
});