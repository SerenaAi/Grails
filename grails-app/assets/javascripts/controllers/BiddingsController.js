app.controller("BiddingsController", function($scope, Biddings, Bidding, $routeParams, Auth, $location){
    var biddings={}

    var refresh=function(){
        biddings = Biddings.query({id:$routeParams.id})
    }

    $scope.getBiddings=function(){
        return biddings
    }

    $scope.createBidding=function(){
        if(Auth.account!=null && Auth.account!=undefined){
            var newBidding={
                'listing':parseInt($routeParams.id),
                'biddingAccount':parseInt(Auth.account.id),
                'amount':$scope.amount
            }
            Bidding.save(newBidding, function(){
                refresh()
                $location.path('listings/'+ $routeParams.id)
            })
        }
        else{
            alert("please login first")
        }
    }
    refresh()
})