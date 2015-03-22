<%@ page import="org.auction.Review" %>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewerAccount', 'error')} required">
    <label for="reviewerAccount">
        <g:message code="review.reviewerAccount.label" default="Reviewer" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="reviewerAccount" name="reviewerAccount.id" from="${org.auction.Account.list()}" optionKey="id" required="" optionValue="username"  value="${reviewInstance?.reviewerAccount?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'bidderComment', 'error')} required">
	<label for="bidderComment">
		<g:message code="review.bidderComment.label" default="Comment" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="bidderComment" maxlength="50" required="" value="${reviewInstance?.bidderComment}"/>
</div>
	<g:hiddenField id="revieweeAccount" name="revieweeAccount.id" optionKey="id"  value="${reviewInstance?.revieweeAccount?.id}" />



