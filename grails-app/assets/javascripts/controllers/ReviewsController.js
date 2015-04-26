app.controller("ReviewsController", function($scope, Reviews){
    var reviews={}
    var refresh=function(){
        reviews = Reviews.query()
    }
    $scope.getReviews=function(){
        return reviews
    }
    refresh()
});