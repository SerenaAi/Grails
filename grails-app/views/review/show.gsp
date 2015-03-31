<%@ page import="org.auction.Review" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'review.label', default: 'Review')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
                <li><g:link action="show" controller="listing" id="${reviewInstance?.listing.id}"><g:message message="Listing List" /></g:link></li>
			</ul>
		</div>
		<div id="show-review" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list review">
				<g:if test="${reviewInstance?.sellerComment}">
				<li class="fieldcontain">
					<span id="sellerComment-label" class="property-label"><g:message code="review.sellerComment.label" default="Seller Comment" /></span>
						<span class="property-value" aria-labelledby="sellerComment-label"><g:fieldValue bean="${reviewInstance}" field="sellerComment"/></span>
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.bidderComment}">
				<li class="fieldcontain">
					<span id="bidderComment-label" class="property-label"><g:message code="review.bidderComment.label" default="Bidder Comment" /></span>
						<span class="property-value" aria-labelledby="bidderComment-label"><g:fieldValue bean="${reviewInstance}" field="bidderComment"/></span>
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.revieweeAccount}">
				<li class="fieldcontain">
					<span id="revieweeAccount-label" class="property-label"><g:message code="review.revieweeAccount.label" default="Reviewee Account" /></span>
						<span class="property-value" aria-labelledby="revieweeAccount-label"><g:link controller="account" action="show" id="${reviewInstance?.revieweeAccount?.id}">${reviewInstance?.revieweeAccount?.username}</g:link></span>
				</li>
				</g:if>
			
				<g:if test="${reviewInstance?.reviewerAccount}">
				<li class="fieldcontain">
					<span id="reviewerAccount-label" class="property-label"><g:message code="review.reviewerAccount.label" default="Reviewer Account" /></span>
						<span class="property-value" aria-labelledby="reviewerAccount-label"><g:link controller="account" action="show" id="${reviewInstance?.reviewerAccount?.id}">${reviewInstance?.reviewerAccount?.username}</g:link></span>
				</li>
				</g:if>
			</ol>
		</div>
	</body>
</html>
