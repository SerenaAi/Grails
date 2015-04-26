app.controller("ReviewController", function($scope, Reviews, $routeParams, Auth){
    var review={}
    var refresh=function(){
        review = Reviews.get({id: $routeParams.id})
    }

    $scope.getReview=function(){
        return review
    }
    $scope.setReviewee=function(id){
        $scope.reviewee=id
    }

    $scope.createSellerReview=function(){
        if(Auth.account!=null && Auth.account!=undefined){
            var newReview={
                'reviewerAccount': Auth.account.id,
                'revieweeAccount': $scope.reviewee,
                'sellerComment': $scope.sellerComment,
                'listing':$routeParams.id
            }
            Reviews.save(newReview,function(){
                alert("reviews: seller saved")
            })
        }else{
            alert("reviews: please login first")
        }
    }


    $scope.createBidderReview=function(){
        if(Auth.account!=null && Auth.account!=undefined){
            var newReview={
                'reviewerAccount': Auth.account.id,
                'revieweeAccount': $scope.reviewee,
                'bidderComment': $scope.bidderComment,
                'listing':$routeParams.id
            }
            Reviews.save(newReview,function(){
                alert("reviews: bidder saved")
            })
        }else{
            alert("reviews: please login first")
        }
    }
    refresh()
});