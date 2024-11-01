<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Review</title>
</head>
<body>
<h1>Edit Review</h1>
<form action="review?action=update" method="post">
    <input type="hidden" name="reviewId" value="${review.reviewId}"/>
    <textarea name="content">${review.content}</textarea><br/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>