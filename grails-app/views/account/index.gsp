<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link action="create"><g:message message="Create Account" /></g:link></li>
    </ul>
</div>
<div class="content" role="main">
    <h1>
        <g:message message="Login" />
    </h1>

    <g:form url="[resource:accountInstance, action:'check']" >
    <fieldset class="form">
        <g:render template="signinform"/>
    </fieldset>
    <fieldset class="buttons">
        <g:submitButton name="submit" class="save" value="Submit" />
    </fieldset>
</g:form>
    </div>
</body>
</html>