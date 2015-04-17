'use strict';

angular.module('app').config(function ($routeProvider) {
  $routeProvider.when("/", {templateUrl: "templates/home.html"});
  $routeProvider.when("/home", {templateUrl: "templates/home.html"});
  $routeProvider.when("/signup", {templateUrl: "templates/signup.html"});

  $routeProvider.when("/listings", {templateUrl: "templates/listings/show.html"});
  $routeProvider.when("/listings/create", {templateUrl: "templates/listings/create.html"});

  $routeProvider.when("/listings/:id", {templateUrl: "templates/listing/show.html"});
  $routeProvider.when("/listings/edit/:id", {templateUrl: "templates/listing/edit.html"});
  $routeProvider.when("/listings/bidding/:id", {templateUrl: "templates/listing/bidding.html"});

  $routeProvider.when("/accounts/:id", {templateUrl: "templates/account/show.html"});
  $routeProvider.when("/accounts/edit/:id", {templateUrl: "templates/account/edit.html"});

    $routeProvider.when("/reviews", {templateUrl: "templates/reviews/show.html"});
    $routeProvider.when("/reviews/:id", {templateUrl: "templates/review/show.html"});
  // Default route: plays screen
//  $routeProvider.otherwise({templateUrl: "templates/plays.html"});
});