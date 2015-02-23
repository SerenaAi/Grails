<%@ page import="org.auction.DeliverOption" %>



<div class="fieldcontain ${hasErrors(bean: deliverOptionInstance, field: 'listings', 'error')} ">
	<label for="listings">
		<g:message code="deliverOption.listings.label" default="Listings" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${deliverOptionInstance?.listings?}" var="l">
    <li><g:link controller="listing" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="listing" action="create" params="['deliverOption.id': deliverOptionInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'listing.label', default: 'Listing')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: deliverOptionInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="deliverOption.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${deliverOptionInstance?.name}"/>

</div>

