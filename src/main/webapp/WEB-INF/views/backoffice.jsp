<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:url var="getAllReservations" value="/backoffice/reservation/getAll"></c:url>
<c:url var="getAllReservationsOnDate" value="/backoffice/reservation/getAllOnDate"></c:url>

<a href="${getAllReservations}">View all reservations</a>

<form:form method="GET" action="${getAllReservationsOnDate}" commandName="dateForm">
    <form:label path="date">Date:</form:label>
    <form:input type="date" path="date"/>
    <input type="submit" value="View all reservations on date"/>
</form:form>

</body>
</html>
