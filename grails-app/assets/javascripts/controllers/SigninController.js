app.controller("SigninController", function($scope, Signin, Accounts, Auth){
    $scope.isAlert=undefined
    $scope.signin = function(){
        var data='j_username='+$scope.username+'&j_password='+$scope.password;
        Signin.check(data).$promise.then(function(data){
            if(data.error){
                isSignin=false;
                $scope.isAlert=true
                alert(data.error)
            }
            if(data.success){
                username=data.username
                Accounts.get({name:username},function(data){
                    Auth.account=data
                })
                $scope.isAlert=false
            }
        })
    }
})