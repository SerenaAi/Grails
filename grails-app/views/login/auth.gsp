<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/auction/assets/bootstrap.css?compile=false" />
    <link rel="stylesheet" href="/auction/assets/main.css?compile=false" />
    <link rel="stylesheet" href="/auction/assets/mobile.css?compile=false" />
    <link rel="stylesheet" href="/auction/assets/application.css?compile=false" />
    <script src="/auction/assets/jquery/jquery-1.11.1.js?compile=false" type="text/javascript"></script>
    <script src="/auction/assets/jquery.js?compile=false" type="text/javascript"></script>
    <script src="/auction/assets/application.js?compile=false" type="text/javascript"></script>

    <meta name="layout" content="main" />

    <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>

<body>

    <div class="nav" role="navigation">
        <ul>
            <!--   <li><a class="home" href="/auction/">Home</a></li> -->
            <li><a href="/auction/listing/index">Listing List</a></li>
            <li><a href="/auction/account/create">Create Account</a></li>
        </ul>
    </div>

    <div class="content scaffold-create" role="main">
        <h1>Please Login</h1>

        <div id='login'>
            <div>

                <form action='/auction/j_spring_security_check' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                    <fieldset>
                        <div class="fieldcontain">
                            <label for='username'>Username:</label>
                            <input type='text' class='text_' name='j_username' id='username' />
                        </div>

                        <div class="fieldcontain">
                            <label for='password'>Password:</label>
                            <input type='password' class='text_' name='j_password' id='password' />
                        </div>
                    </fieldset>

                    <fieldset class="buttons">
                        <input type="submit" name="create" class="save" value="Login" id="create" />
                    </fieldset>
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
