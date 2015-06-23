<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="true"%>

<div id="contents" align="left" class="container" style="width: 100%; margin-bottom: 20px; margin-top: 20px; min-width: 674px; height: 500px">
  <div class="sign_up_left">
    <h3><img src="<c:url value="/resources/logo/Phybee.png"/>" style="height: 50px; width: auto"> Phybee</h3>
    <br />
    <label><spring:message code="register.desc" /></label>
    <br />
    <label style="font-size: 13px"><spring:message code="register.advantage" /></label>
  </div>
      <div class="account-wall">
        <h3>Create your account</h3>
        <form:form modelAttribute="userForm" method="POST" cssClass="form-signin" cssStyle="width: 100%">
        <table style="float: left; width: 100%">
          <tr>
            <td style="padding-left: 20%; width: 35%; text-align: right; padding-right: 5px"><label><spring:message code="register.firstName" /></label></td>
            <td><form:input path="firstName" value="" cssStyle="width: 100%; margin-left: auto"/></td>
            <form:errors path="firstName" element="div" cssClass="alert-danger"/>
          </tr>
          <tr>
            <td style="padding-left: 20%; width: 35%; text-align: right; padding-right: 5px"><label><spring:message code="register.lastName" /></label></td>
            <td><form:input path="lastName" value="" cssStyle="width: 100%; margin-left: auto"/></td>
            <form:errors path="lastName" element="div" cssClass="alert-danger"/>
          </tr>
          <tr>
            <td style="padding-left: 20%; width: 35%; text-align: right; padding-right: 5px"><label>Email</label></td>
            <td><form:input path="email" value="" cssStyle="width: 100%; margin-left: auto"/></td>
            <form:errors path="email" element="div" cssClass="alert-danger"/>
          </tr>
          <tr>
            <td style="padding-left: 20%; width: 35%; text-align: right; padding-right: 5px"><label><spring:message code="register.password" /></label></td>
            <td><form:input path="password" value="" type="password" cssStyle="width: 100%; margin-left: auto"/></td>
            <form:errors path="password" element="div" cssClass="alert-danger"/>
          </tr>
          <tr>
            <td style="width: 35%; text-align: right; padding-right: 5px"><label><spring:message code="register.cpassword" /></label></td>
            <td><form:input path="matchingPassword" value="" type="password" cssStyle="width: 100%; margin-left: auto"/></td>
            <form:errors element="div" cssClass="alert-danger"/>
          </tr>
        </table>
          <button type="submit" class="btn btn-lg btn-primary btn-block" style="align-content: center"><spring:message code="register.signUp" /></button>
        </form:form>
        <%--
          <a href="<c:url value="login.html" />">
            <spring:message code="label.form.loginLink"></spring:message>
          </a>
        --%>
      </div>
</div>
