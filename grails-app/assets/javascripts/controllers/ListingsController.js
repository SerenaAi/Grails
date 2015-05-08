app.controller("ListingsController", function($scope, Listings, $routeParams, $location, Auth) {
    var listings = {}
    var completed = false;
    $scope.button = "Show Completed"

    var refresh = function() {
        if (completed == false) {
            listings = Listings.query()
        } else {
            listings = Listings.select({
                completed: true
            })
        }
    }

    $scope.completedSwitch = function() {
        if (completed == false) {
            completed = true
            $scope.button = "Show All"
        } else {
            completed = false
            $scope.button = "Show Completed"
        }
        refresh()
    }

    $scope.getListings = function() {
        return listings
    }

    $scope.setOption = function(id) {
        $scope.option = id;
    }

    //create listing
    $scope.saveListing = function() {
        if (Auth.account != null && Auth.account != undefined) {
            var newListing = {
                'name': $scope.listingName,
                'description': $scope.description,
                'startPrice': parseInt($scope.startPrice),
                'listingDays': parseInt($scope.listingDays),
                'startDate': '2015-05-12T07:30:00Z', //change!
                'sellerAccount': parseInt(Auth.account.id),
                'deliverOption': parseInt($scope.option)
            }
            Listings.save(newListing, function() {
                refresh()
                $(".my-alerts").html($("<div />")
                    .html("Listing was successfully created!")
                    .addClass("alert alert-success listing-create-success")
                );
                $location.path('listings')
            })
        } else {
            $(".my-alerts").html($("<div />")
                .html("savelisting: please login first")
                .addClass("alert alert-danger listing-create-failed")
            );
        }
    }

    //delete listing
    $scope.deleteListing = function() {
        Listings.delete({
            id: $routeParams.id
        }, function() {
            refresh()
            $location.path('listings')
        })
    }

    refresh()
});
