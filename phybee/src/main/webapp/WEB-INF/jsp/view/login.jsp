<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAnonymous()">
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>

	<form name="loginForm" action="<c:url value='/auth/login_check' />"
		method="POST" class="form">
		<spring:message code="field.email" />
		: <input type='text' name="email" />
		<spring:message code="field.password" />
		: <input type='password' name="password" /> <input type="submit"
			value="<spring:message code="field.login" />" class="btn" />
	</form>
</sec:authorize>


