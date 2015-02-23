<%@ page import="org.auction.Listing" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'listing.label', default: 'Listing')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-listing" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-listing" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list listing">
			
				<g:if test="${listingInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="listing.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${listingInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="listing.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${listingInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.startPrice}">
				<li class="fieldcontain">
					<span id="startPrice-label" class="property-label"><g:message code="listing.startPrice.label" default="Start Price" /></span>
					
						<span class="property-value" aria-labelledby="startPrice-label"><g:fieldValue bean="${listingInstance}" field="startPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="listing.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${listingInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.listingDays}">
				<li class="fieldcontain">
					<span id="listingDays-label" class="property-label"><g:message code="listing.listingDays.label" default="Listing Days" /></span>
					
						<span class="property-value" aria-labelledby="listingDays-label"><g:fieldValue bean="${listingInstance}" field="listingDays"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${listingInstance?.createdDate}">
				<li class="fieldcontain">
					<span id="createdDate-label" class="property-label"><g:message code="listing.createdDate.label" default="Created Date" /></span>
					
						<span class="property-value" aria-labelledby="createdDate-label"><g:formatDate date="${listingInstance?.createdDate}" /></span>
					
				</li>
				</g:if>
			
				%{--<g:if test="${listingInstance?.account}">--}%
				%{--<li class="fieldcontain">--}%
					%{--<span id="account-label" class="property-label"><g:message code="listing.account.label" default="Account" /></span>--}%
						%{--<span class="property-value" aria-labelledby="account-label"><g:link controller="account" action="show" id="${listingInstance?.account?.id}">${listingInstance?.account?.encodeAsHTML()}</g:link></span>--}%
				%{--</li>--}%
				%{--</g:if>--}%
				%{--<g:if test="${listingInstance?.deliveroption}">--}%
				%{--<li class="fieldcontain">--}%
					%{--<span id="deliveroption-label" class="property-label"><g:message code="listing.deliveroption.label" default="Deliveroption" /></span>--}%
						%{--<span class="property-value" aria-labelledby="deliveroption-label"><g:link controller="deliverOption" action="show" id="${listingInstance?.deliveroption?.id}">${listingInstance?.deliveroption?.encodeAsHTML()}</g:link></span>--}%
				%{--</li>--}%
				%{--</g:if>--}%
			
			</ol>
			<g:form url="[resource:listingInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${listingInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
