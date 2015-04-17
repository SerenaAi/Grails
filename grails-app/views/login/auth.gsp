<!DOCTYPE html>
<head>
    <title>MyAuction Login</title>
    <asset:stylesheet src="application.css" />
    <asset:javascript src="application.js" />
</head>

<body>
    <div class="container">
        <h3>Please sign in</h3>
        <hr />
        <div class="row">
                <div class="col-lg-4 col-lg-offset-2">
                <form class="form-signin" action='/auction/j_spring_security_check' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                    <fieldset>
                        <div class="fieldcontain">
                            <label for='username'>Username:</label>
                            <input type='text' class="form-control" placeholder="Username"  class='text_' name='j_username' id='username' />
                        </div>

                        <div class="fieldcontain">
                            <label for='password'>Password:</label>
                            <input type='password' class="form-control" placeholder="Password"  class='text_' name='j_password' id='password' />
                        </div>
                    </fieldset>
                    <p></p>
                    <button  class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>
    </div>

    <script type='text/javascript'>
        <!--
        (function() {
            document.forms['loginForm'].elements['j_username'].focus();
        })();
        // -->
    </script>

</body>

</html>
