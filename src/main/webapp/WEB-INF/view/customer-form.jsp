<%--
  Created by IntelliJ IDEA.
  User: maya
  Date: 21.06.19
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Customer</title>
    <!-- reference our style sheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add_customer_style.css">

</head>
<body>
<div id="wrapper">

    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="POST">

        <!-- need to associate this data with customer id -->
        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>

<div style="clear: both"></div>
<p><a href="${pageContext.request.contextPath}/customer/list">Back to the list of customers</a></p>

</body>
</html>
