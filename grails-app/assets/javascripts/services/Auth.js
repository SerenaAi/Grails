app.factory('Auth', function() {
    var serv={}
    serv.isLoggedIn=function(){
        if(serv.account!=null && serv.account!=undefined) return true
        else return false
    }
    return serv
})