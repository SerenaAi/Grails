app.controller("AccountController", function($scope, Accounts, $routeParams){
    var account={}
    var refresh=function(){
        account = Accounts.get({id: $routeParams.id})
    }

    $scope.getAccount=function(){
        return account
    }
    refresh()
});