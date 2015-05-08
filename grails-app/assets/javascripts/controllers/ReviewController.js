app.controller("ReviewController", function($scope, Reviews, $routeParams, Auth) {
    var review = {}
    var refresh = function() {
        review = Reviews.get({
            id: $routeParams.id
        })
    }

    $scope.getReview = function() {
        return review
    }
    $scope.setReviewee = function(id) {
        $scope.reviewee = id
    }

    $scope.createSellerReview = function() {
        if (Auth.account != null && Auth.account != undefined) {
            var newReview = {
                'reviewerAccount': Auth.account.id,
                'revieweeAccount': $scope.reviewee,
                'sellerComment': $scope.sellerComment,
                'listing': $routeParams.id
            }
            Reviews.save(newReview, function() {
                $(".my-alerts").html($("<div />")
                    .html("Seller feedback was successfully saved!")
                    .addClass("alert alert-success listing-seller-feedback-success")
                );
            })
        } else {
            $(".my-alerts").html($("<div />")
                .html("reviews: please login first")
                .addClass("alert alert-danger listing-seller-feedback-failed")
            );
        }
    }


    $scope.createBidderReview = function() {
        if (Auth.account != null && Auth.account != undefined) {
            var newReview = {
                'reviewerAccount': Auth.account.id,
                'revieweeAccount': $scope.reviewee,
                'bidderComment': $scope.bidderComment,
                'listing': $routeParams.id
            }
            Reviews.save(newReview, function() {
                $(".my-alerts").html($("<div />")
                    .html("Seller feedback was successfully saved!")
                    .addClass("alert alert-success listing-bidder-feedback-success")
                );
            })
        } else {
            $(".my-alerts").html($("<div />")
                .html("reviews: please login first")
                .addClass("alert alert-danger listing-bidder-feedback-failed")
            );
        }
    }
    refresh()
});
