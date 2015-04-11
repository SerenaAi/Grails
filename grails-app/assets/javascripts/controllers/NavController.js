app.controller("NavController", ['$scope',function($scope){
    //defa
    var tabID=1;
    var pageID=1;
    $scope.setNavID=function(tabid, pageid){
        tabID=tabid;
        pageID=pageid;
    }

    $scope.isTabID=function(tabid){
        if(tabID===tabid) return true;
        else return false;
    }
    $scope.isPageID=function(pageid){
        if(pageID===pageid) return true;
        else return false;
    }
}]);