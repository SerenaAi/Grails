app.controller("ReviewController", function($scope, Reviews, $routeParams){
    var review={}
    var refresh=function(){
        review = Reviews.get({id: $routeParams.id})
    }

    $scope.getReview=function(){
        return review
    }

    refresh()
});