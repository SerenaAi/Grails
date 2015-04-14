app.controller("BiddingsController", function($scope, Biddings, $routeParams){
    var biddings={}
    var refresh=function(){
        biddings = Biddings.query({id:$routeParams.id})
    }
    $scope.getBiddings=function(){
        return biddings
    }
    refresh()
})