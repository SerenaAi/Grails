<%@ page import="org.auction.Bidding" %>


<g:textField hidden="true" id="biddingAccount" name="biddingAccount.id" value="${biddingInstance?.biddingAccount?.id}"/>

<div class="fieldcontain ${hasErrors(bean: biddingInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="bidding.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: biddingInstance, field: 'amount')}" required=""/>
</div>
    <g:hiddenField  name="listing.id" value="${biddingInstance?.listing.id}" />

