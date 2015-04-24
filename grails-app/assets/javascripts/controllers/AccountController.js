app.controller("AccountController", function($scope, Accounts, Auth){
    var account={}
    var refresh=function(){
        if(Auth.account!=null && Auth.account!=undefined){
            account = Accounts.get({id: Auth.account.id})
            $scope.username=account.username
            $scope.email=account.email
            $scope.password=account.password
            $scope.address=account.address
        }else{
        }
    }

    $scope.getAccount=function(){
        return account
    }
    $scope.editAccount=function(){
        alert("rads")
        if(Auth.account!=null&&Auth.account!=undefined){
            var newAccount={}
            newAccount.username=$scope.username
            newAccount.email=$scope.email
            newAccount.password=$scope.password
            newAccount.address=$scope.address
            $id=Auth.account.id
            Accounts.update({id: $id}, newAccount).$promise.then(function(){
                //alert()
            })
        }
    }


    $scope.getAccountName=function(id){
        return Accounts.get({id: id})
    }

    refresh()
});