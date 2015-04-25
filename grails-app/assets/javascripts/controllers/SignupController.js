app.controller("SignupController", function($scope, Accounts){
    $scope.signup=function(){
        var newAccount={}
        newAccount.email=$scope.email
        newAccount.password=$scope.password
        newAccount.username=$scope.username
        newAccount.address=$scope.address
        Accounts.save(newAccount).$promise.then(function(data){

        });
    }

});