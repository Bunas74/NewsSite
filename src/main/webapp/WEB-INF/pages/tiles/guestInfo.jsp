<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message.news" var="message_news" />
<fmt:message bundle="${loc}" key="local.message.latest_news" var="message_latest_news" />
<fmt:message bundle="${loc}" key="local.message.no_news" var="message_no_news" />

<div class="body-title">
	<h2><c:out value="${message_latest_news}" /></h2>
</div>
<br>
<hr>
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
		</div>
	</div>
	<hr>
</c:forEach>
<br><br>
<div class="no-news">
	<c:if test="${requestScope.news eq null}">
       <h2><c:out value="${message_no_news}" /></h2>
	</c:if>
</div>