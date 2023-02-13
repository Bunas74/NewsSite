<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message.save" var="message_save" />
<fmt:message bundle="${loc}" key="local.message.edit_news" var="message_edit_news" />


<div class="body-title">
	<h2> <c:out value="${message_edit_news}" /> </h2>
	<br>
	<hr>
</div>
<div class="add-table-margin">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_edit_news"/>
		<input type="hidden" name="idNews" value="${requestScope.news.idNews}"/>	
		<table class="news_text_format">
			<tr>
				<td class="space_around_title_text">
					News Title
				</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="title" value="${requestScope.news.title}"/>
					</div>
				</td>
			</tr>		
			<tr>
				<td class="space_around_title_text">
					Brief
				</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="briefNews" value="${requestScope.news.briefNews}"/>
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">
					Content
				</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<textarea rows="10" cols="50" name="content">
							${requestScope.news.content }
						</textarea>
					</div>
				</td>
			</tr>
		</table>		
		<c:if test="${sessionScope.role eq 'admin'}">
			<div class="first-view-button">
				<input type="submit" value="${message_save}" />
			</div>
		</c:if>	
	</form>
</div>