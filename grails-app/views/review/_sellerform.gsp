<%@ page import="org.auction.Review" %>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'reviewerAccount', 'error')} required">
    <label for="reviewerAccount">
        <g:message code="review.reviewerAccount.label" default="Reviewer" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="reviewerAccount" name="reviewerAccount.id" from="${org.auction.Account.list()}" optionKey="id" optionValue="name" required="" value="${reviewInstance?.reviewerAccount?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reviewInstance, field: 'sellerComment', 'error')} required">
	<label for="sellerComment">
		<g:message code="review.sellerComment.label" default="Comment" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="sellerComment" maxlength="50" required="" value="${reviewInstance?.sellerComment}"/>
 </div>

<g:hiddenField id="revieweeAccount" name="revieweeAccount.id" optionKey="id" value="${reviewInstance?.revieweeAccount?.id}"/>


