<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message.news" var="message_news" />
<fmt:message bundle="${loc}" key="local.message.view_news" var="message_view_news" />
<fmt:message bundle="${loc}" key="local.message.edit" var="message_edit" />
<fmt:message bundle="${loc}" key="local.message.delete" var="message_delete" />

<div class="body-title">
	<h2><c:out value="${message_view_news}" /></h2>
	<br>
	<hr>
</div>
<div class="add-table-margin">
	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text">News Title</td>
			<td class="space_around_view_text">
				<div class="word-breaker">
					<c:out value="${requestScope.news.title }" />
				</div>
			</td>
		</tr>
		<tr>
			<td class="space_around_title_text">News Date</td>
			<td class="space_around_view_text">
				<div class="word-breaker">
					<c:out value="${requestScope.news.newsDate }" />
				</div>
			</td>
		</tr>
		<tr>
			<td class="space_around_title_text">Brief</td>
			<td class="space_around_view_text">
				<div class="word-breaker">
					<c:out value="${requestScope.news.briefNews }" />
				</div>
			</td>
		</tr>
		<tr>
			<td class="space_around_title_text">Content</td>
			<td class="space_around_view_text">
				<div class="word-breaker">
					<c:out value="${requestScope.news.content }" />
				</div>
			</td>
		</tr>
	</table>
</div>
<c:if test="${sessionScope.role eq 'admin'}">
	<div class="first-view-button">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_edit_news_page" />
			<input type="hidden" name="idNews" value="${news.idNews}" /> <input
				type="submit" value="${message_edit}" />
		</form>
	</div>
	<div class="second-view-button">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="do_delete_news" /> <input
				type="hidden" name="idNews" value="${news.idNews}" /> <input
				type="submit" value="${message_delete}" />
		</form>
	</div>
</c:if>
