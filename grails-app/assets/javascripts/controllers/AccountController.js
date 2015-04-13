app.controller("AccountController", function($scope, Accounts){
    var account={}
    var refresh=function(){
        account = Accounts.get({id:2});
    }


    $scope.getAccount=function(id){
        return Accounts.get({id:id});
    }
    refresh();
});