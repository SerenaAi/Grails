app.controller("OptionController", function($scope, Options, $rootScope) {
    var options = {}
    var refresh = function() {
        options = Options.query()
    }
    $scope.setCurrentName = function(name) {
        $scope.name = name
    }
    $scope.getOptions = function() {
        return options
    }

    $rootScope.$on("readOptionName", function(event, args) {
        Options.get({
            id: args.currentOption
        }, function(data) {
            $scope.name = data.name
        })
    })
    refresh()
});
