<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
	<div class="msg">${msg}</div>
</c:if>

<form name="loginForm" action="<c:url value='/auth/login_check' />"
	method="POST" class="form-signin">
	<h4>
		<span class="label label-primary"><spring:message
				code="field.email" /> :</span>
	</h4>
	<input type='text' name="email" />
	<h4>
		<span class="label label-primary"><spring:message
				code="field.password" /> :</span>
	</h4>
	<input type='password' name="password" /> <br />
	<button type="submit" class="btn btn-lg btn-primary btn-block">
		<spring:message code="field.login" />
	</button>
</form>