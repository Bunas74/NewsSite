<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message.news" var="message_news" />
<fmt:message bundle="${loc}" key="local.message.edit_news" var="message_edit_news" />
<fmt:message bundle="${loc}" key="local.message.view_news" var="message_view_news" />
<fmt:message bundle="${loc}" key="local.message.no_news" var="message_no_news" />


<div class="body-title">
	<h2><c:out value="${message_news}" /></h2>
	<br>
	<hr>
</div>

<form action="" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}" />
				</div>
				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'user'}">
							<a href="controller?command=go_to_view_news&idNews=${news.idNews}"><c:out value="${message_view_news}" /></a>
						</c:if>
						<c:if test="${sessionScope.role eq 'admin'}">
							<a href="controller?command=go_to_edit_news_page&idNews=${news.idNews}"><c:out value="${message_edit_news}" /> </a>					
							&nbsp;&nbsp;
							<a href="controller?command=go_to_view_news&idNews=${news.idNews}"><c:out value="${message_view_news}" /></a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<br>
		<hr>
	</c:forEach>
</form>
<br><br>
<div class="no-news">
	<c:if test="${requestScope.news eq null}">
       <h2><c:out value="${message_no_news}" /></h2>
	</c:if>
</div>
