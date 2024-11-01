<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Write Review</title>
</head>
<body>
<h1>Write a New Review</h1>
<form action="review?action=write" method="post">
    <input type="text" name="videoId" placeholder="Video ID"/><br/>
    <input type="text" name="userId" placeholder="User ID"/><br/>
    <textarea name="content" placeholder="Write your review"></textarea><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>