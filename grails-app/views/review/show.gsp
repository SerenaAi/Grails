
<%@ page import="org.auction.Review" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'review.label', default: 'Review')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-review" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-review" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list review">
			
				<g:if test="${reviewInstance?.comment}">
				<li class="fieldcontain">
					<span id="comment-label" class="property-label"><g:message code="review.comment.label" default="Comment" /></span>
					
						<span class="property-value" aria-labelledby="comment-label"><g:fieldValue bean="${reviewInstance}" field="comment"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.listing}">
				<li class="fieldcontain">
					<span id="listing-label" class="property-label"><g:message code="review.listing.label" default="Listing" /></span>
					
						<span class="property-value" aria-labelledby="listing-label"><g:link controller="listing" action="show" id="${reviewInstance?.listing?.id}">${reviewInstance?.listing?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.reviewer}">
				<li class="fieldcontain">
					<span id="reviewer-label" class="property-label"><g:message code="review.reviewer.label" default="Reviewer" /></span>
					
						<span class="property-value" aria-labelledby="reviewer-label"><g:link controller="account" action="show" id="${reviewInstance?.reviewer?.id}">${reviewInstance?.reviewer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.reviewing}">
				<li class="fieldcontain">
					<span id="reviewing-label" class="property-label"><g:message code="review.reviewing.label" default="Reviewing" /></span>
					
						<span class="property-value" aria-labelledby="reviewing-label"><g:link controller="account" action="show" id="${reviewInstance?.reviewing?.id}">${reviewInstance?.reviewing?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.voted}">
				<li class="fieldcontain">
					<span id="voted-label" class="property-label"><g:message code="review.voted.label" default="Voted" /></span>
					
						<span class="property-value" aria-labelledby="voted-label"><g:formatBoolean boolean="${reviewInstance?.voted}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:reviewInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${reviewInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
