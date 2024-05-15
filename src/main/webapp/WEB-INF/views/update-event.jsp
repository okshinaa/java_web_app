<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Event</title>
</head>
<body>
<h1>Edit Event</h1>
<form action="${pageContext.request.contextPath}/update-event" method="post">
    <input type="hidden" name="eventId" value="${event.id}">
    <label for="type">Type:</label>
    <select id="type" name="type">
        <option value="Birthday" ${event.type eq 'Birthday' ? 'selected' : ''}>Birthday</option>
        <option value="Important" ${event.type eq 'Important' ? 'selected' : ''}>Important</option>
    </select><br>
    <label for="date">Date:</label>
    <input type="date" id="date" name="date" value="${event.date}">
    <br>
    <label for="description">Description:</label><br>
    <textarea id="description" name="description">${event.description}</textarea><br>
    <input type="submit" value="Save Changes">
</form>
</body>
</html>
