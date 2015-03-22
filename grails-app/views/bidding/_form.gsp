<%@ page import="org.auction.Bidding" %>



<div class="fieldcontain ${hasErrors(bean: biddingInstance, field: 'biddingAccount', 'error')} required">
	<label for="account">
		<g:message code="bidding.biddingAccount.label" default="Bidding Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="biddingAccount" name="biddingAccount.id" from="${org.auction.Account.list()}" optionKey="id" required="" optionValue="username" value="${biddingInstance?.biddingAccount?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: biddingInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="bidding.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: biddingInstance, field: 'amount')}" required=""/>
</div>
    <g:hiddenField  name="listing.id" value="${biddingInstance?.listing.id}" />

