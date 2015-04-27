app.controller("SigninController", function($scope, Signin, Accounts, Auth) {
    $scope.signin = function() {
        var data = 'j_username=' + $scope.username + '&j_password=' + $scope.password;
        Signin.check(data).$promise.then(function(data) {
            if (data.error) {
                $(".my-alerts").html($("<div />")
                    .html(data.error)
                    .addClass("alert alert-danger login-fail")
                );
            }
            if (data.success) {
                $(".my-alerts").html($("<div />")
                    .html("Successfully loggedin!")
                    .addClass("alert alert-success login-success")
                );
                username = data.username
                Accounts.get({
                    name: username
                }, function(data) {
                    Auth.account = data
                })
            }
        })
    }
})
