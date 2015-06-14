<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page session="true"%>
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 14/06/2015
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="account-wall">
    <h3>Change your password</h3>
    <form:form modelAttribute="pwdForm" method="POST" cssClass="form-signin" cssStyle="width: 100%; height: 400px">
    <table style="float: left; width: 100%">
        <tr>
            <td style="padding-left: 20%; width: 35%; text-align: right; padding-right: 5px"><label>New password</label></td>
            <td><form:input path="password" type="password" value="" cssStyle="width: 100%; margin-left: auto"/></td>
        </tr>
        <tr>
            <td style="width: 35%; text-align: right; padding-right: 5px"><label><spring:message code="register.cpassword" /></label></td>
            <td><form:input path="matchingPassword" value="" type="password" cssStyle="width: 100%; margin-left: auto"/></td>
            <form:errors element="div" />
        </tr>
    </table>
    <button type="submit" class="btn btn-lg btn-primary btn-block" style="align-content: center">Update</button>
    </form:form>
</div>