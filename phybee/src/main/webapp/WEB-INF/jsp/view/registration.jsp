<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="true"%>

<div id="contents" align="center" class="container row col-sm-6 col-md-4 col-md-offset-4">
      <div class="account-wall">
        <h3>Create your account</h3>
        <form:form modelAttribute="userForm" method="POST" enctype="utf8" class="form-signin">
          <br/>
          <table>
          <tr>
            <td><label><spring:message code="register.firstName" /></label></td>
            <td><form:input path="firstName" value="" /></td>
            <form:errors path="firstName" element="div"/>
          </tr>
          <tr>
            <td><label><spring:message code="register.lastName" /></label></td>
            <td><form:input path="lastName" value="" /></td>
            <form:errors path="lastName" element="div" />
          </tr>
          <tr>
            <td><label>Email:</label></td>
            <td><form:input path="email" value="" /></td>
            <form:errors path="email" element="div" />
          </tr>
          <tr>
            <td><label><spring:message code="register.password" /></label></td>
            <td><form:input path="password" value="" type="password" /></td>
            <form:errors path="password" element="div" />
          </tr>
          <tr>
            <td><label><spring:message code="register.cpassword" /></label></td>
            <td><form:input path="matchingPassword" value="" type="password" /></td>
            <form:errors element="div" />
          </tr>
          <tr>
            <td><button type="submit" class="btn btn-lg btn-primary btn-block" ><spring:message code="register.signUp" /></button>
            </td>
          </tr>
          </table>
        </form:form>
        <br/>
        <%--
          <a href="<c:url value="login.html" />">
            <spring:message code="label.form.loginLink"></spring:message>
          </a>
        --%>
      </div>
</div>
