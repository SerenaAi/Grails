<!DOCTYPE html>
<html>

<head>
    <title>Welcome to MyAuction</title>
    <asset:stylesheet src="application.css" />
    <asset:javascript src="application.js" />
</head>

<body ng-app="app">
<div class="logo">
    <a href="/auction/" title="Goto Home" style="color:inherit; text-decoration: none;">
        <i class="fa fa-area-chart" style="font-size: 90%; color: #c8c8ca;"></i> MyAuction
        <small style="color: rgba(153, 201, 113, 0.78); font-size: 22px;">.com</small>
    </a>
</div>
<div ng-controller="NavController">

<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
    <li role="presentation"><a href="#listings" aria-controls="profile" role="tab" data-toggle="tab">show Listings</a></li>
    <li role="presentation"><a href="#account" aria-controls="messages" role="tab" data-toggle="tab">My Account</a></li>
</ul>

    <ng-view></ng-view>

</div>
<hr>
<footer class="text-center">
    <p>&copy; Go & Sa 2015</p>
</footer>
</div>
</body>

</html>