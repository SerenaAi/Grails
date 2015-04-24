app.controller("AccountController", function($scope, Accounts, Auth){
    var account={}
    var refresh=function(){
        if(Auth.account!=null && Auth.account!=undefined){
            account = Accounts.get({id: Auth.account.id})
        }else{
        }
    }

    $scope.getAccount=function(){
        return account
    }

    $scope.getAccountName=function(id){
        return Accounts.get({id: id})
    }

    refresh()
});