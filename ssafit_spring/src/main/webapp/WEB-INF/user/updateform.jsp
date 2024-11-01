<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<h1>Edit Profile</h1>
<form action="user?action=update" method="post">
    <input type="hidden" name="userId" value="${user.userId}"/>
    <input type="text" name="userName" value="${user.name}"/><br/>
    <input type="email" name="userEmail" value="${user.email}"/><br/>
    <input type="password" name="password" placeholder="New Password"/><br/>
    <input type="submit" value="Save Changes"/>
</form>
</body>
</html>