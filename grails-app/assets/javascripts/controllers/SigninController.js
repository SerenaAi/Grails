app.controller("SigninController", function($scope, Signin, Accounts, Auth) {

    $scope.signin = function() {
        var data = 'j_username=' + $scope.username + '&j_password=' + $scope.password;
        Signin.check(data).$promise.then(function(data) {
            var alert=angular.element("#login-alert")
            alert.html("")
            if (data.error) {
                alert.append($("<div />")
                    .html("login failed ! "+data.error)
                    .addClass("alert alert-danger login-fail")
                );
            }
            if (data.success) {
                alert.append($("<div />")
                    .html("login success !")
                    .addClass("alert alert-success login-success")
                );

                Accounts.get({
                    name: data.username
                }, function(data) {
                    Auth.account = data
                })
            }
        })
    }
})
