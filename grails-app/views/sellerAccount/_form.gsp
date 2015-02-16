<%@ page import="org.auction.SellerAccount" %>



<div class="fieldcontain ${hasErrors(bean: sellerAccountInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="sellerAccount.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="account" name="account.id" from="${org.auction.Account.list()}" optionKey="id" required="" value="${sellerAccountInstance?.account?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sellerAccountInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="sellerAccount.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${sellerAccountInstance?.email}"/>

</div>

