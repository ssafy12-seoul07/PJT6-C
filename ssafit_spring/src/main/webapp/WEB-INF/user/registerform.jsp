<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h1>Register a New User</h1>
<form action="user?action=register" method="post">
    <input type="text" name="userId" placeholder="User ID"/><br/>
    <input type="password" name="password" placeholder="Password"/><br/>
    <input type="text" name="userName" placeholder="Name"/><br/>
    <input type="email" name="userEmail" placeholder="Email"/><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>