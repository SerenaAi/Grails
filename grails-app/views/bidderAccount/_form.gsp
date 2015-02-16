<%@ page import="org.auction.BidderAccount" %>



<div class="fieldcontain ${hasErrors(bean: bidderAccountInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="bidderAccount.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="account" name="account.id" from="${org.auction.Account.list()}" optionKey="id" required="" value="${bidderAccountInstance?.account?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bidderAccountInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="bidderAccount.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${bidderAccountInstance?.email}"/>

</div>

