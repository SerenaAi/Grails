<%@ page import="org.auction.Bidding" %>



<div class="fieldcontain ${hasErrors(bean: biddingInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="bidding.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="account" name="account.id" from="${org.auction.Account.list()}" optionKey="id" required="" optionValue="name" value="${biddingInstance?.account?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: biddingInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="bidding.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: biddingInstance, field: 'amount')}" required=""/>

</div>


<div class="fieldcontain ${hasErrors(bean: biddingInstance, field: 'listing', 'error')} required">
	<label for="listing">
		<g:message code="bidding.listing.label" default="Listing" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="listing" name="listing.id" from="${org.auction.Listing.list()}" optionKey="id" required="" optionValue="name" value="${biddingInstance?.listing?.id}" class="many-to-one"/>

</div>

