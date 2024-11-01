<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Favorite Videos</title>
</head>
<body>
<h1>Favorite Videos</h1>
<c:forEach var="favorite" items="${favoriteList}">
    <p>Video ID: ${favorite.videoId}</p>
</c:forEach>
</body>
</html>