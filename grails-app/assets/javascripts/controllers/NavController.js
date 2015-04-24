app.controller("NavController", function($scope, $location,Auth){
    $scope.href = function (path, id ) {
        $location.path( path+'/'+id )
    }
    $scope.showAccount=function(){
        if(Auth.account!=null && Auth.account!=undefined) return true
        else return false
    }
})