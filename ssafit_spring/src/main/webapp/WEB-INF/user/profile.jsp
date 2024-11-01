<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
<h1>User Profile</h1>
<p>ID: ${user.userId}</p>
<p>Name: ${user.name}</p>
<p>Email: ${user.email}</p>
<a href="user?action=updateform&userId=${user.userId}">Edit Profile</a>
<a href="user?action=delete&userId=${user.userId}">Delete Account</a>
</body>
</html>