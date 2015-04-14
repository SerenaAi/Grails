'use strict';

angular.module('app').config(function ($routeProvider) {
  $routeProvider.when("/home", {templateUrl: "templates/home.html"});
  $routeProvider.when("/signup", {templateUrl: "templates/signup.html"});

  $routeProvider.when("/listings", {templateUrl: "templates/listings/show.html"});
  $routeProvider.when("/listings/create", {templateUrl: "templates/listings/create.html"});

  $routeProvider.when("/listings/:id", {templateUrl: "templates/listing/show.html"});
  $routeProvider.when("/listings/:id/edit", {templateUrl: "templates/listing/edit.html"});
  $routeProvider.when("/listings/:id/bidding", {templateUrl: "templates/listing/bidding.html"});

  $routeProvider.when("/accounts/:id", {templateUrl: "templates/account/show.html"});
  $routeProvider.when("/accounts/:id/edit", {templateUrl: "templates/account/edit.html"});

  // Default route: plays screen
//  $routeProvider.otherwise({templateUrl: "templates/plays.html"});
});