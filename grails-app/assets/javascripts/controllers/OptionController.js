app.controller("OptionController", function($scope, Options){
    var options={}
    var optionID
    var refresh=function(){
        options = Options.query()
    }
    $scope.getOptions=function(){
        return options
    }
    $scope.setOptionID=function(id){
        optionID= id
    }
    refresh()
});