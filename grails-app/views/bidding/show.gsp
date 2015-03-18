

<%@ page import="org.auction.Bidding" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bidding.label', default: 'Bidding')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bidding" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link controller="listing" action="index"><g:message message="Listing List" /></g:link></li>
			</ul>
		</div>
		<div id="show-bidding" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bidding">
			
				<g:if test="${biddingInstance?.biddingAccount}">
				<li class="fieldcontain">
					<span id="biddingAccount-label" class="property-label"><g:message code="bidding.biddingAccount.label" default="Bidding Account" /></span>
					
						<span class="property-value" aria-labelledby="biddingAccount-label"><g:link controller="account" action="show" id="${biddingInstance?.biddingAccount?.id}">${biddingInstance?.biddingAccount?.name}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${biddingInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="bidding.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${biddingInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${biddingInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="bidding.dateCreated.label" default="Date Created" /></span>
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${biddingInstance?.dateCreated}" /></span>
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:biddingInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
