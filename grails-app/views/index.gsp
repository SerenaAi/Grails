<!DOCTYPE html>
<html>
	<head>
		<title>Welcome to MyAuction</title>
        <asset:stylesheet src="application.css"/>
        <asset:javascript src="application.js"/>
	</head>
	<body  ng-app="app">
    <div class="logo">
        <a href="/auction/" title="Goto Home" style="color:inherit; text-decoration: none;">
            <i class="fa fa-area-chart" style="font-size: 90%; color: #c8c8ca;"></i>
            MyAuction<small style="color: rgba(153, 201, 113, 0.78); font-size: 22px;">.com</small>
        </a>
    </div>
        <div ng-controller="NavController">
            <div role="tabpanel">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab" ng-click="setNavID(1,1)">Home</a></li>
                    <li role="presentation"><a href="#listing" aria-controls="profile" role="tab" data-toggle="tab" ng-click="setNavID(2,1)">show Listings</a></li>
                    <li role="presentation"><a href="#account" aria-controls="messages" role="tab" data-toggle="tab" ng-click="setNavID(3,1)">My Account</a></li>
                </ul>
                <div class="tab-content">

                    <div role="tabpanel" class="tab-pane active" id="home" ng-show="isTabID(1)">
                        <!--/.home page1-->
                        <div class="container" ng-show="isPageID(1)">
                            <div class="row row-offcanvas row-offcanvas-right">
                                <div class="col-xs-12 col-sm-9">
                                    <p class="pull-right visible-xs">
                                        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
                                    </p>
                                    <div class="jumbotron">
                                        <h2>Welcome to MyAuction<small>.com</small></h2>
                                        <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
                                        <p><a class="btn btn-primary btn-lg" href="#" role="button" ng-click="setNavID(1,2)">Sign up now</a></p>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-6 col-lg-4">
                                            <h2>Heading</h2>
                                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                                            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                                        </div><!--/.col-xs-6.col-lg-4-->
                                        <div class="col-xs-6 col-lg-4">
                                            <h2>Heading</h2>
                                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                                            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                                        </div><!--/.col-xs-6.col-lg-4-->
                                        <div class="col-xs-6 col-lg-4">
                                            <h2>Heading</h2>
                                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                                            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4 col-md-3 sidebar-offcanvas" id="sidebar">
                                    <h4>Sign in:</h4>
                                    <form>
                                        <div class="form-group">
                                            <input type="text" placeholder="Email" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" placeholder="Password" class="form-control">
                                        </div>
                                        <button type="submit" class="btn btn-success">Sign in</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--/.home page2-->
                        <div class="container" ng-show="isPageID(2)">
                            <form class="form-signin">
                                <h3 class="form-signin-heading">Please sign up</h3>
                                <hr />
                                    <div class="col-lg-4">
                                        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                                        <p></p>
                                        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
                                        <p></p>
                                        <input type="username" id="inputUsername" class="form-control" placeholder="Username" required="" autofocus="">
                                        <p></p>
                                        <input type="address" id="inputAddress" class="form-control" placeholder="Address" required="" autofocus="">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" value="remember-me"> Remember me
                                        </label>
                                    </div>
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                                </div>
                            </form>
                        </div>
                    </div><!--/.home-->

                    <div role="tabpanel" class="tab-pane" id="listing" ng-show="isTabID(2)">
                        <div class="container">
                            <h3>Listings</h3>
                            <hr />
                            <div class="row">
                                <div role="tabpanel">
                                    <div class="col-sm-3 col-md-2">
                                        <ul class="left-nav nav-pills nav-stacked">
                                            <li class="active"><a href="#showlisting"  role="tab" data-toggle="tab" >show Listings</a></li>
                                            <li><a href="#createlisting"  role="tab" data-toggle="tab">Create Listings</a></li>
                                        </ul>
                                    </div>
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active" id="showlisting">
                                                <div class="col-sm-9 col-md-10" >
                                                    <div class="box">
                                                        <div class="box-light">
                                                            <h4>Show Listing</h4>
                                                            <hr />
                                                                <form class="bs-example bs-example-form" data-example-id="input-group-dropdowns">
                                                                    <div class="searchbar">
                                                                    <div class="input-group">
                                                                        <div class="input-group-btn">
                                                                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                                                                Name
                                                                                <span class="caret"></span></button>
                                                                            <ul class="dropdown-menu" role="menu">
                                                                                <li><a href="#">Name</a></li>
                                                                                <li><a href="#">Description</a></li>
                                                                            </ul>
                                                                        </div><!-- /btn-group -->
                                                                        <input type="text" class="form-control">
                                                                        <span class="input-group-addon">
                                                                            Completed
                                                                            <input type="checkbox" aria-label="Checkbox for following text input">
                                                                        </span>
                                                                    </div><!-- /input-group -->
                                                                </div><!-- /.col-lg-6 -->
                                                                </form>
                                                                <p></p>
                                                        <table class="table" ng-controller="ListingController">
                                                        <thead>
                                                         <tr>
                                                            <th>Completed</th>
                                                            <th>Listing Name</th>
                                                            <th>Start Price</th>
                                                            <th>Start Date</th>
                                                            <th>Listing Days</th>
                                                            <th>Seller Account Name</th>
                                                            <th>Deliver Option</th>
                                                            <th>Description</th>
                                                        </tr>
                                                        </thead>
                                                            <tbody ng-repeat="item in getData() track by item.id">
                                                                <tr style="cursor: pointer" ng-click="setNavID(4,1)">
                                                                    <td>{{item.completed}}</td>
                                                                    <td>Otto</td>
                                                                    <td>@mdo</td>
                                                                    <td>@mdo</td>
                                                                    <td>@mdo</td>
                                                                    <td>@mdo</td>
                                                                    <td>@mdo</td>
                                                                    <td>@mdo</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div role="tabpanel" class="tab-pane" id="createlisting">
                                            <div class="col-sm-9 col-md-10" >
                                                <div class="box">
                                                    <div class="box-light">
                                                        <h4>Create Listing</h4>
                                                        <hr />
                                                        <div class="row">
                                                            <div class="col-lg-8 col-md-offset-1">
                                                                <div class="row">
                                                                    <div class="col-md-3">Name:</div>
                                                                    <div class="col-md-9"><input type="text" class="form-control"></div>
                                                                </div>
                                                                <div class="row">
                                                                        <div class="col-md-3">Description:</div>
                                                                        <div class="col-md-9"><input type="text" class="form-control"></div>
                                                                    </div>
                                                                <div class="row">
                                                                        <div class="col-md-3">Start Price:</div>
                                                                        <div class="col-md-9"><input type="number" min="0" class="form-control" style="width: 100px"></div>
                                                                    </div>
                                                                <div class="row">
                                                                        <div class="col-md-3">Start Date:</div>
                                                                        <div class="col-md-9"><input type="date" class="form-control"></div>
                                                                    </div>
                                                                <div class="row">
                                                                        <div class="col-md-3">Listings Days:</div>
                                                                        <div class="col-md-9"><input type="number" min="1" class="form-control" style="width: 100px"></div>
                                                                    </div>
                                                                <div class="row">
                                                                        <div class="col-md-3">Deliver Option:</div>
                                                                        <div class="col-md-9">
                                                                            <div class="dropdown">
                                                                                <button class="btn btn-default dropdown-toggle" type="button" id="dd-deliveroption" data-toggle="dropdown" aria-expanded="true">
                                                                                    <span class="caret"></span>
                                                                                </button>
                                                                                <ul class="dropdown-menu" role="menu" aria-labelledby="dd-deliveroption">
                                                                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                <p></p>
                                                                <button type="button" class="btn btn-primary btn-lg btn-block">Create</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--/.listing-->

                    <div role="tabpanel" class="tab-pane" id="account" ng-show="isTabID(3)">
                        <div class="container">
                            <h3>Account</h3>
                            <hr />
                            <div class="row">
                                <div role="tabpanel">
                                    <div class="col-sm-3 col-md-2">
                                        <ul class="left-nav nav-pills nav-stacked">
                                            <li class="active"><a href="#showaccount"  role="tab" data-toggle="tab">show Account</a></li>
                                            <li><a href="#editaccount"  role="tab" data-toggle="tab">Edit Account</a></li>
                                            <li><a href="#">Delete Account</a></li>
                                        </ul>
                                    </div>
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active" id="showaccount">
                                            <div class="col-sm-9 col-md-10">
                                                <div class="box">
                                                    <div class="box-light">
                                                        <h4>Show Account</h4>
                                                        <hr />
                                                        <div class="row">
                                                            <div class="col-lg-8 col-md-offset-1">
                                                                <div class="row">
                                                                    <div class="col-md-3">Username:</div>
                                                                    <div class="col-md-9">miao</div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-3">Email:</div>
                                                                    <div class="col-md-9">miao@g.com</div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-3">Address:</div>
                                                                    <div class="col-md-9">12 st se</div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-3">Last Updated:</div>
                                                                    <div class="col-md-9">5-11-1111</div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <p></p>
                                                        <h4>Reviews</h4>
                                                        <hr />
                                                        <table class="table">
                                                            <thead>
                                                            <tr>
                                                                <th>Completed</th>
                                                                <th>Listing Name</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            <tr>
                                                                <td>Mark</td>
                                                                <td>Otto</td>
                                                            </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div role="tabpanel" class="tab-pane" id="editaccount">
                                            <div class="col-sm-9 col-md-10">
                                                <div class="box">
                                                    <div class="box-light">
                                                        <h4>Edit Account</h4>
                                                        <hr />
                                                        <div class="row">
                                                            <div class="col-lg-8 col-md-offset-1">
                                                                <div class="row">
                                                                    <div class="col-md-3">Username:</div>
                                                                    <div class="col-md-9"><input type="text" class="form-control"></div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-3">Email:</div>
                                                                    <div class="col-md-9"><input type="text" class="form-control"></div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-3">Password:</div>
                                                                    <div class="col-md-9"><input type="text" class="form-control"></div>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-3">Address:</div>
                                                                    <div class="col-md-9"><input type="text" class="form-control"></div>
                                                                </div>
                                                                <p></p>
                                                                <button type="button" class="btn btn-primary btn-lg btn-block">Edit</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--/.account-->

                    <div ng-show="isTabID(4)">
                    <div class="container">
                        <h3>Listing Details</h3>
                        <hr />
                        <div class="row">
                            <div role="tabpanel">
                                <div class="col-sm-3 col-md-2">
                                    <ul class="left-nav nav-pills nav-stacked">
                                        <li class="active"><a href="#listingdetail"  role="tab" data-toggle="tab" >Listing Details</a></li>
                                        <li><a href="#editlisting"  role="tab" data-toggle="tab" >Edit Listing</a></li>
                                        <li><a href="#createbidding"  role="tab" data-toggle="tab">Create bidding</a></li>
                                        <li><a href="#deletelisting">Delete Listing</a></li>
                                    </ul>
                                </div>
                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="listingdetail">
                                        <div class="col-sm-9 col-md-10">
                                            <div class="box">
                                                <div class="box-light">
                                                    <h4>Show Account</h4>
                                                    <hr />
                                                    <div class="row">
                                                        <div class="col-lg-8 col-md-offset-1">
                                                            <div class="row">
                                                                <div class="col-md-3">Name:</div>
                                                                <div class="col-md-9">listing 1</div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Description:</div>
                                                                <div class="col-md-9">listing 1 description</div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Start Price:</div>
                                                                <div class="col-md-9">$ 1</div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Start Date:</div>
                                                                <div class="col-md-9">5-11-1111</div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Listing Days:</div>
                                                                <div class="col-md-9">5</div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Deliver Option:</div>
                                                                <div class="col-md-9">US only</div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Seller Account:</div>
                                                                <div class="col-md-9">miao</div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <p></p>
                                                    <h4>Winner Account</h4>
                                                    <hr />
                                                    <h4>Highest Bid</h4>
                                                    <hr />
                                                    <h4>Bidding History</h4>
                                                    <hr />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div role="tabpanel" class="tab-pane" id="editlisting">
                                        <div class="col-sm-9 col-md-10" >
                                            <div class="box">
                                                <div class="box-light">
                                                    <h4>Edit Listing</h4>
                                                    <hr />
                                                    <div class="row">
                                                        <div class="col-lg-8 col-md-offset-1">
                                                            <div class="row">
                                                                <div class="col-md-3">Name:</div>
                                                                <div class="col-md-9"><input type="text" class="form-control"></div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Description:</div>
                                                                <div class="col-md-9"><input type="text" class="form-control"></div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Start Price:</div>
                                                                <div class="col-md-9"><input type="number" min="0" class="form-control" style="width: 100px"></div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Start Date:</div>
                                                                <div class="col-md-9"><input type="date" class="form-control"></div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Listings Days:</div>
                                                                <div class="col-md-9"><input type="number" min="1" class="form-control" style="width: 100px"></div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-3">Deliver Option:</div>
                                                                <div class="col-md-9">
                                                                    <div class="dropdown">
                                                                        <button class="btn btn-default dropdown-toggle" type="button" id="dd-deliveroption" data-toggle="dropdown" aria-expanded="true">
                                                                            <span class="caret"></span>
                                                                        </button>
                                                                        <ul class="dropdown-menu" role="menu" aria-labelledby="dd-deliveroption">
                                                                            <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <p></p>
                                                            <button type="button" class="btn btn-primary btn-lg btn-block">Edit</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div role="tabpanel" class="tab-pane" id="createbidding">
                                        <div class="col-sm-9 col-md-10" >
                                            <div class="box">
                                                <div class="box-light">
                                                    <h4>Create Bidding</h4>
                                                    <hr />
                                                    <div class="row">
                                                        <div class="col-lg-8 col-md-offset-1">
                                                            <div class="row">
                                                                <div class="col-md-3">Bidding Amount:</div>
                                                                <div class="col-md-9"><input type="text" class="form-control" style="width:100px"></div>
                                                            </div>

                                                            <p></p>
                                                            <button type="button" class="btn btn-primary btn-lg btn-block">Create</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.bidding-->
                </div>
            </div>
            <hr>
            <footer class="text-center">
                <p>&copy; Go & Sa 2015</p>
            </footer>
        </div>
	</body>
</html>
