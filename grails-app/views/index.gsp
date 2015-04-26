<%@ page import="grails.plugin.springsecurity.web.SecurityRequestHolder; org.auction.User;" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to MyAuction</title>
    <asset:stylesheet src="application.css" />
    <asset:javascript src="application.js" />
    <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>

<body ng-app="app">
    <div class="logo">
        <a href="" title="Goto Home" style="color:inherit; text-decoration: none;">
            <i class="fa fa-area-chart" style="font-size: 90%; color: #c8c8ca;"></i> MyAuction
            <small style="color: rgba(153, 201, 113, 0.78); font-size: 22px;">.com</small>
        </a>
    </div>
    <div ng-controller="NavController">
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">Home</a></li>
            <li role="presentation"><a href="#listings" role="tab" data-toggle="tab">show Listings</a></li>
            <li role="presentation"><a href="#accounts" role="tab" data-toggle="tab">My Account</a></li>
            <li role="presentation"><a href="#reviews" role="tab" data-toggle="tab">Reviews</a></li>
        </ul>

        <div class="col-md-12 my-alerts">
        </div>

        <ng-view></ng-view>
    </div>
    <hr>
    <footer class="text-center">
        <p>&copy; Go & Sa 2015</p>
    </footer>
    </div>

</body>
</html>
