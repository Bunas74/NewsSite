<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message.add" var="message_add" />
<fmt:message bundle="${loc}" key="local.message.add_news" var="message_add_news" />


<div class="body-title">
	<h2>
		<c:out value="${message_add_news}" />
	</h2>
	<br>
	<hr>
</div>

<div class="add-table-margin" align="left">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_add_news" />
		<table class="news_text_format">
			<tr>
				<td class="space_around_title_text">News Title</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="title" />
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">Brief</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="briefNews" />
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">Content</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<textarea rows="15" cols="50" name="content"></textarea>
					</div>
				</td>
			</tr>
		</table>
		<c:if test="${sessionScope.role eq 'admin'}">
			<div class="first-view-button">
				<input type="submit" value="${message_add_news}" />
			</div>
		</c:if>
	</form>
</div>