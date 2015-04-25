app.controller("AccountController", function($scope, Accounts, Auth, $location){
    var account={}

    //get current login account info
    var refresh=function(){
        if(Auth.account!=null && Auth.account!=undefined){
            Accounts.get({id: Auth.account.id}, function(data){
                account=data
                $scope.username= account.username
                $scope.email=account.email
                $scope.password=account.password
                $scope.address=account.address
            })
        }else{
            alert("account: please login first")
        }
    }
    $scope.getAccount=function(){
        return account
    }

    $scope.editAccount=function(){
        if(Auth.account!=null && Auth.account!=undefined){
            var newAccount={
                'username': $scope.username,
                'email': $scope.email,
                'password': $scope.password,
                'address': $scope.address
            }
            $id=Auth.account.id
            Accounts.update({id: $id}, newAccount, function(){
                refresh()
                $location.path( 'accounts')
            })
        }else{
            alert("editaccount: please login first")
        }
    }

    $scope.createAccount=function(){
        var newAccount={
            'username': $scope.create_username,
            'email': $scope.create_email,
            'password': $scope.create_password,
            'address': $scope.create_address
        }
        Accounts.save(newAccount,function(){
            delete newAccount
            $location.path( 'home')
        })
    }
    refresh()
});