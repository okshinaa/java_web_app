<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event List</title>
</head>
<body>
<h1>Event List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Date</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="event" items="${events}">
        <tr>
            <td>${event.id}</td>
            <td>${event.type}</td>
            <td>${event.date}</td>
            <td>${event.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/create-event.jsp">Add Event</a>
<a href="${pageContext.request.contextPath}/update-event.jsp">Update Event</a>
<a href="${pageContext.request.contextPath}/delete-event.jsp">Delete Event</a>
</body>
</html>
