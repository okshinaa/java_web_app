<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Event</title>
</head>
<body>
<h1>Add Event</h1>
<form action="${pageContext.request.contextPath}/create-event" method="post">
    <label for="type">Type:</label>
    <select id="type" name="type">
        <option value="Birthday">Birthday</option>
        <option value="Important">Important</option>
    </select><br>
    <label for="date">Date:</label>
    <input type="date" id="date" name="date"><br>
    <label for="description">Description:</label><br>
    <textarea id="description" name="description"></textarea><br>
    <input type="submit" value="Add Event">
</form>
</body>
</html>
