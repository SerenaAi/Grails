<%@ page import="org.auction.Account" %>
<html>
<head>
	<meta name='layout' content='main'/>
	<title><g:message code="springSecurity.login.title"/></title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
     <!--   <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li> -->
        <li><g:link action="index" controller="listing"><g:message message="Listing List" /></g:link></li>
        <li><g:link action="create" controller="account"><g:message message="Create Account" /></g:link></li>
    </ul>
</div>

<div class="content scaffold-create" role="main">
    <h1><g:message code="springSecurity.login.header"/></h1>

    <div id='login'>
	<div>
        <g:if test="${flash.message}">
        <ul class="errors" role="alert">
                <li><g:message error="${flash.message}"/></li>
        </ul>
        </g:if>
		<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
            <fieldset>
			<div class="fieldcontain">
				<label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
				<input type='text' class='text_' name='j_username' id='username'/>
			</div>

			<div class="fieldcontain">
				<label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
				<input type='password' class='text_' name='j_password' id='password'/>
			</div>
            </fieldset>

            <fieldset class="buttons">
                <g:submitButton name="create" class="save" value="${message(code: "springSecurity.login.button")}" />
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
