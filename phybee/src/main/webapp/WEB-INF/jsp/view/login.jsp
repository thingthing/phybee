<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<ul class="nav pull-right navbar-nav">
	<sec:authorize access="isAnonymous()">
		<li class="dropdown" id="menuLogin"><a class="dropdown-toggle"
			href="#" data-toggle="dropdown" id="navLogin">Login</a>
			<div class="dropdown-menu" style="padding: 17px;">
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
						value="<spring:message code="field.login" />" class="btn"/>
				</form>
			</div></li>
	</sec:authorize>

	<li><sec:authorize access="hasRole('ROLE_USER')">
			<a href="<c:url value="/profil"/>"> <c:if
					test="${pageContext.request.userPrincipal.name != null}">
			${user.firstName} ${user.lastName}
	</c:if>
			</a>


		</sec:authorize></li>

	<li><a href="?lang=en">EN</a></li>
	<li><a href="?lang=fr">FR</a></li>
</ul>

