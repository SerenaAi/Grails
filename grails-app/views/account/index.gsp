<%@ page import="org.auction.Account" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link action="index" controller="listing"><g:message message="Listing List" /></g:link></li>
                <li><g:link action="show" controller="account" id="${params.id}"><g:message message="Show Account" /></g:link></li>
                <li class="pull-right">
                    <g:form controller="logout">
                        <a href="#" onclick="document.forms[0].submit()">Logout</a>
                     </g:form>
                </li>
            </ul>
		</div>
        <div class="content scaffold-show" role="main">
            <ol class="property-list account">
                <h1 class="text-center">Welcome </h1>
            </ol>
        </div>
	</body>
</html>
