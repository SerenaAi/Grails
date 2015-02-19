<%@ page import="org.auction.Account" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
    <div class="container">
      <div class="header">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li class="active"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
          </ul>
        </nav>
        <h3 class="logo-css text-muted"><i class="fa fa-legal"></i> MyAuction</h3>
      </div>

      <div class="row marketing">
        <div class="col-lg-12">
          <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
          </g:if>
          <h3><g:message code="default.list.label" args="[entityName]" /></h3>
          <table class="table table-striped">
          <thead>
            <tr>
              <g:sortableColumn property="address" title="${message(code: 'account.address.label', default: 'Address')}" />
              <g:sortableColumn property="email" title="${message(code: 'account.email.label', default: 'Email')}" />
              <g:sortableColumn property="name" title="${message(code: 'account.name.label', default: 'Name')}" />
              <g:sortableColumn property="password" title="${message(code: 'account.password.label', default: 'Password')}" />
            </tr>
          </thead>
          <tbody>
          <g:each in="${accountInstanceList}" status="i" var="accountInstance">
          <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <td><g:link action="show" id="${accountInstance.id}">${fieldValue(bean: accountInstance, field: "address")}</g:link></td>
            <td>${fieldValue(bean: accountInstance, field: "email")}</td>
            <td>${fieldValue(bean: accountInstance, field: "name")}</td>
            <td>${fieldValue(bean: accountInstance, field: "password")}</td>
          </tr>
          </g:each>
          </tbody>
          </table>
        </div>
      </div>

      <footer class="footer">
        <p>&copy; MyAuction</p>
      </footer>
    </div>

    <!--
		<div id="list-account" class="content scaffold-list" role="main">
			<div class="pagination">
				<g:paginate total="${accountInstanceCount ?: 0}" />
			</div>
		</div> -->
	</body>
</html>
