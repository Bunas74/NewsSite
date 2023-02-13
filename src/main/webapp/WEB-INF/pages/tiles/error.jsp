<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.out" var="out_button" />
<fmt:message bundle="${loc}" key="local.message.error_page" var="message_error_page" />
<fmt:message bundle="${loc}" key="local.message.error_page_one" var="message_error_page_one" />
<fmt:message bundle="${loc}" key="local.message.error_page_two" var="message_error_page_two" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<h2><c:out value="${message_error_page}" /></h2>
	<br>
	<hr>
	<br>
	<h4><c:out value="${message_error_page_one}" /></h4>
	<br>
	<h4>
		<font color="red"><c:out value="${sessionScope.error}" /></font>
	</h4>
	<br>
	<h4><c:out value="${message_error_page_two}" /></h4>
	<br>
	<br>
	<c:if test="${not (sessionScope.user eq 'active')}">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_base_page" /> 
			<input type="submit" value="${out_button }" />
		</form>
	</c:if>
	<c:if test="${sessionScope.user eq 'active'}">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_news_list" /> 
			<input type="submit" value="${out_button }" />
		</form>
	</c:if>
</body>
</html>