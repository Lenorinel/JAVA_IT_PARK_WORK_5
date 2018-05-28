<%@ page import="ru.itpark.service.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers List</title>
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>Email</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.login}</td>
            <td>${customer.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
