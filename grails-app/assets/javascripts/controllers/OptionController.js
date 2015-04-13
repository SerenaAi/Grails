app.controller("OptionController", function($scope, Options){
    var options={}
    var refresh=function(){
        options = Options.query()
    }
    $scope.getOptions=function(){
        return options
    }
    refresh()
});