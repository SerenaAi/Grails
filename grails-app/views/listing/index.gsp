<%@ page import="org.auction.Listing" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'listing.label', default: 'Listing')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-listing" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<!--<li><a href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li> -->
                <li><g:link action="create" controller="listing"><g:message message="Create Listing" /></g:link></li>
                <li class="pull-right"><g:link action="show" controller="account"><g:message message="My Account" /></g:link></li>
            </ul>
		</div>
		<div id="list-listing" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <fieldset class="form">
                    <g:form action="index" method="GET">
                        <div class="fieldcontain">
                            <label for="query">Search by</label>
                            <g:select name="searchtype" value="${params.searchtype}"
                                      from="${[1: 'Name', 2: 'Description']}"
                                      optionKey="key" optionValue="value" />

                            <g:textField name="query" value="${params.query}"/>
                            <g:select name="listtype" value="${params.listtype}"
                                      from="${[1: 'Show All', 2: 'Show Completed', 3: 'Show Uncompleted']}"
                                      optionKey="key" optionValue="value" />
                            <input type="submit" value="Go">
                        </div>
                    </g:form>
                </fieldset>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'listing.name.label', default: 'Name')}" />
						<g:sortableColumn property="description" title="${message(code: 'listing.description.label', default: 'Description')}" />
						<g:sortableColumn property="startPrice" title="${message(code: 'listing.startPrice.label', default: 'Start Price')}" />
						<g:sortableColumn property="startDate" title="${message(code: 'listing.startDate.label', default: 'Start Date')}" />
						<g:sortableColumn property="listingDays" title="${message(code: 'listing.listingDays.label', default: 'Listing Days')}" />
                        <g:sortableColumn property="completed" title="${message(code: 'listing.completed.label', default: 'Completed')}" />
                        <g:sortableColumn property="account" title="${message(message: 'Seller Account')}" />
                    </tr>
				</thead>
				<tbody>
				<g:each in="${listingInstanceList}" status="i" var="listingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${listingInstance.id}">${fieldValue(bean: listingInstance, field: "name")}</g:link></td>
						<td>${fieldValue(bean: listingInstance, field: "description")}</td>
						<td>${fieldValue(bean: listingInstance, field: "startPrice")}</td>
						<td><g:formatDate date="${listingInstance.startDate}" format="yyyy-MM-dd" /></td>
						<td>${fieldValue(bean: listingInstance, field: "listingDays")}</td>
                        <td>${fieldValue(bean: listingInstance, field: "completed")}</td>
                        <td>${fieldValue(bean: listingInstance, field: "sellerAccount.username")}</td>
                    </tr>
				</g:each>
				</tbody>
			</table>
            <div class="pagination">
            <g:paginate next="Forward" prev="Back" controller="listing" action="index" total="${listingInstanceCount ?: 0}" params="${params}" />
        </div>
     </div>

	</body>
</html>
