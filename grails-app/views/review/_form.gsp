<%@ page import="org.auction.Review" %>



<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'comment', 'error')} required">
	<label for="comment">
		<g:message code="review.comment.label" default="Comment" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="comment" maxlength="50" required="" value="${reviewInstance?.comment}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'listing', 'error')} required">
	<label for="listing">
		<g:message code="review.listing.label" default="Listing" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="listing" name="listing.id" from="${org.auction.Listing.list()}" optionKey="id" optionValue="name" required="" value="${reviewInstance?.listing?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewer', 'error')} required">
	<label for="reviewer">
		<g:message code="review.reviewer.label" default="Reviewer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reviewer" name="reviewer.id" from="${org.auction.Account.list()}" optionKey="id" optionValue="name" required="" value="${reviewInstance?.reviewer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewing', 'error')} required">
	<label for="reviewing">
		<g:message code="review.reviewing.label" default="Reviewing" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reviewing" name="reviewing.id" from="${org.auction.Account.list()}" optionKey="id" optionValue="name" required="" value="${reviewInstance?.reviewing?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'voted', 'error')} ">
	<label for="voted">
		<g:message code="review.voted.label" default="Voted" />
		
	</label>
	<g:checkBox name="voted" value="${reviewInstance?.voted}" />

</div>

