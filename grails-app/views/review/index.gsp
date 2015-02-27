
<%@ page import="org.auction.Review" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'review.label', default: 'Review')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-review" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-review" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="comment" title="${message(code: 'review.comment.label', default: 'Comment')}" />
					
						<th><g:message code="review.listing.label" default="Listing" /></th>
					
						<th><g:message code="review.reviewer.label" default="Reviewer" /></th>
					
						<th><g:message code="review.reviewing.label" default="Reviewing" /></th>
					
						<g:sortableColumn property="voted" title="${message(code: 'review.voted.label', default: 'Voted')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reviewInstanceList}" status="i" var="reviewInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reviewInstance.id}">${fieldValue(bean: reviewInstance, field: "comment")}</g:link></td>
					
						<td>${fieldValue(bean: reviewInstance, field: "listing")}</td>
					
						<td>${fieldValue(bean: reviewInstance, field: "reviewer")}</td>
					
						<td>${fieldValue(bean: reviewInstance, field: "reviewing")}</td>
					
						<td><g:formatBoolean boolean="${reviewInstance.voted}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reviewInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
