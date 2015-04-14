app.controller("ReviewsController", function($scope, Reviews, $routeParams){
    var reviews={}
    var refresh=function(){
        reviews = Reviews.query()
    }

    $scope.getReviews=function(){
        return reviews
    }

    refresh()
});