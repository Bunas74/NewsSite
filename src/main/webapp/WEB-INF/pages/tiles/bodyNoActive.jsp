<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${requestScope.presentation eq 'regPage'}">
	<c:import url="/WEB-INF/pages/tiles/registration.jsp" />
</c:if>

<c:if test="${requestScope.presentation eq 'errorPage'}">
	<c:import url="/WEB-INF/pages/tiles/error.jsp" />
</c:if>

<c:if
	test="${requestScope.presentation eq 'guestInfo'}">
	<c:import url="/WEB-INF/pages/tiles/guestInfo.jsp" />
</c:if>