app.controller("SigninController", function($scope, Signin, Accounts, Auth) {
    $scope.signin = function() {
        // client validation
        var errors = [];
        if (!$scope.username) {
            errors.push("Please enter your username");
            $(".login-username").closest(".fieldcontain").addClass("has-error");
        }
        if (!$scope.password) {
            errors.push("Please enter your password");
            $(".login-password").closest(".fieldcontain").addClass("has-error");
        }

        if (errors.length) {
            $(".my-alerts").html($("<div />")
                .html(errors.join("<br>"))
                .addClass("alert alert-danger login-fail")
            );
            return false;
        }

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
