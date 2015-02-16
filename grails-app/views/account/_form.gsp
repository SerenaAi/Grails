<%@ page import="org.auction.Account" %>



<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="account.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" required="" value="${accountInstance?.address}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="account.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${accountInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="account.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="20" required="" value="${accountInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="account.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" maxlength="16" required="" value="${accountInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'listings', 'error')} ">
	<label for="listings">
		<g:message code="account.listings.label" default="Listings" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${accountInstance?.listings?}" var="l">
    <li><g:link controller="listing" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="listing" action="create" params="['account.id': accountInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'listing.label', default: 'Listing')])}</g:link>
</li>
</ul>


</div>

