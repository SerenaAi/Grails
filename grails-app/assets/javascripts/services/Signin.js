app.factory('Signin', function($resource) {
    //send formdata + "ajax=true"
    return $resource('/auction/j_spring_security_check', {}, {
            check: {
                params:{ajax:true},
                method:'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                }
            }
        }
    )
})