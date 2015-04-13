app.controller("NavController", function($scope, $location){
    $scope.href = function (path, id ) {
        $location.path( path+'/'+id )
    }
})