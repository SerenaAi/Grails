app.controller("BiddingsController", function($scope, Biddings, Bidding, $routeParams, Auth, $location) {
    var biddings = {}

    var refresh = function() {
        biddings = Biddings.query({
            id: $routeParams.id
        })
    }

    $scope.getBiddings = function() {
        return biddings
    }

    $scope.createBidding = function() {
        if (Auth.account != null && Auth.account != undefined) {
            var newBidding = {
                'listing': parseInt($routeParams.id),
                'biddingAccount': parseInt(Auth.account.id),
                'amount': $scope.amount
            }
            Bidding.save(newBidding, function() {
                refresh()
                $(".my-alerts").html($("<div />")
                    .html("Bidding was successfully posted!")
                    .addClass("alert alert-success bid-create-success")
                );
                $location.path('listings/' + $routeParams.id)
            })
        } else {
            $(".my-alerts").html($("<div />")
                .html("createbid: please login first")
                .addClass("alert alert-danger bid-create-failed")
            );
        }
    }
    refresh()
})
