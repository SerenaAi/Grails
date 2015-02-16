<%@ page import="org.auction.Listing" %>



<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="listing.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${listingInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="listing.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${listingInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'startPrice', 'error')} required">
	<label for="startPrice">
		<g:message code="listing.startPrice.label" default="Start Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="startPrice" value="${fieldValue(bean: listingInstance, field: 'startPrice')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="listing.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${listingInstance?.startDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'listingDays', 'error')} required">
	<label for="listingDays">
		<g:message code="listing.listingDays.label" default="Listing Days" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="listingDays" type="number" value="${listingInstance.listingDays}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'createdDate', 'error')} required">
	<label for="createdDate">
		<g:message code="listing.createdDate.label" default="Created Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="createdDate" precision="day"  value="${listingInstance?.createdDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: listingInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="listing.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="account" name="account.id" from="${org.auction.Account.list()}" optionKey="id" required="" value="${listingInstance?.account?.id}" class="many-to-one"/>

</div>

