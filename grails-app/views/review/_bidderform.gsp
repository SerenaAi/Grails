<%@ page import="org.auction.Review" %>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'bidderComment', 'error')} required">
	<label for="bidderComment">
        <g:message message="${reviewInstance?.reviewerAccount?.username} comment on ${reviewInstance?.revieweeAccount?.username}:" />
	</label>
	<g:textArea name="bidderComment" maxlength="50" required="" value="${reviewInstance?.bidderComment}"/>
</div>

<g:hiddenField id="revieweeAccount" name="revieweeAccount.id" optionKey="id" value="${reviewInstance?.revieweeAccount?.id}"/>
<g:hiddenField id="reviewerAccount" name="reviewerAccount.id" value="${reviewInstance?.reviewerAccount?.id}" />
<g:hiddenField id="listing" name="listing.id" value="${reviewInstance?.listing?.id}" />


