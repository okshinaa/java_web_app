<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Event</title>
</head>
<body>
<h1>Delete Event</h1>
<p>Вы уверены, что хотите удалить это событие?</p>
<form action="${pageContext.request.contextPath}/delete-event" method="post">
    <input type="hidden" name="eventId" value="${event.id}">
    <input type="submit" value="Yes, Delete Event">
</form>
<a href="${pageContext.request.contextPath}/events">Cancel</a>
</body>
</html>
