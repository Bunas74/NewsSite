<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.send" var="send_button" />
<fmt:message bundle="${loc}" key="local.message.login" var="message_login" />
<fmt:message bundle="${loc}" key="local.message.password" var="message_password" />
<fmt:message bundle="${loc}" key="local.message.reg_page" var="message_reg_page" />
<fmt:message bundle="${loc}" key="local.locbutton.name.out" var="out_button" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<h2>
		<c:out value="${message_reg_page}" />
	</h2>
	<br>
	<hr>
	<br>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_registration" />
		<c:out value="${message_login}" />
		<br /> 
		<input type="email" name="login" value="" placeholder="name@example.com" />
		<br />
		<c:out value="${message_password}" />
		<br /> 
		<input type="password" name="password" value="" placeholder="your password" />
		<br /> 
		<br /> 
		<input class="first-reg-button" type="submit" value="${send_button}" />
	</form>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="go_to_base_page" /> 
		<input class="second-reg-button" type="submit" value="${out_button }" />
	</form>
	<br />
</body>
</html>
