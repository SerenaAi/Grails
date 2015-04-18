app.controller("SigninController", function($scope, Signin){

    var sendPost=function(){
        var data='j_username='+$scope.username+'&j_password='+$scope.password;
        Signin.check(data).$promise.then(function(data){
            if(data.error){
                alert(data.error)
            }
            if(data.success){
                alert("welcome "+data.username)
            }
        });
    }
    $scope.send=function(){
        sendPost();
    }

});