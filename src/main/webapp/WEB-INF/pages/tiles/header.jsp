<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
<fmt:message bundle="${loc}" key="local.message.login" var="message_login" />
<fmt:message bundle="${loc}" key="local.message.password" var="message_password" />
<fmt:message bundle="${loc}" key="local.message.title" var="message_title" />
<fmt:message bundle="${loc}" key="local.message.registration" var="message_registration" />
<fmt:message bundle="${loc}" key="local.locbutton.sign_in" var="sign_in_button" />
<fmt:message bundle="${loc}" key="local.locbutton.sign_out" var="sign_out_button" />

<div class="wrapper">
	<div class="newstitle">
		<c:out value="${message_title}" />
	</div>
	<div class="local-link">
		<div align="right">
			<a href="controller?local=en&command=set_new_local&link=${sessionScope.link}"><c:out value="${en_button}" /></a>
			&nbsp;&nbsp;
			<a href="controller?local=ru&command=set_new_local&link=${sessionScope.link}"><c:out value="${ru_button}" /></a> 
			<br /> 
			<br />
		</div>
		<c:if test="${not (sessionScope.user eq 'active')}">
			<div class="input" align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" />
					<c:out value="${message_login}" />
					<input type="email" name="login" value="" placeholder="name@example.com" />
					<br />
					<c:out value="${message_password}" />
					<input type="password" name="password" value="" placeholder="your password" />
					<br />
					<a href="controller?command=go_to_registration_page"><c:out value="${message_registration}" /></a> 
					<input type="submit" value="${sign_in_button}" />
					<br />
				</form>
			</div>
		</c:if>
		<c:if test="${sessionScope.user eq 'active'}">
			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="${sign_out_button }" />
					<br />
				</form>
			</div>
		</c:if>
	</div>
</div>
