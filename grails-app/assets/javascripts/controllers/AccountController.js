app.controller("AccountController", function($scope, Accounts, $routeParams){
    var account={}
    var refresh=function(){
        account = Accounts.get({id: $routeParams.id})
    }

    $scope.getAccountName=function(id){
        return Accounts.get({id: id})
    }
    $scope.getAccountID=function(){
        return $routeParams.id
    }
    refresh()
});