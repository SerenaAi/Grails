app.controller("BiddingsController", function($scope, Biddings, Bidding, $routeParams, Auth){
    var biddings={}

    var refresh=function(){
        biddings = Biddings.query({id:$routeParams.id})
    }
    $scope.getBiddings=function(){
        return biddings
    }

    $scope.createBiddings=function(){
        var newBiddings={}
        newBiddings.listing=parseInt($routeParams.id)
        if(Auth.account!=null && Auth.account!=undefined){
            newBiddings.biddingAccount=parseInt(Auth.account.id)
        }
        newBiddings.amount=$scope.amount
        Bidding.save(newBiddings).$promise.then(function (data) {
            refresh()
        })
    }
    refresh()
})