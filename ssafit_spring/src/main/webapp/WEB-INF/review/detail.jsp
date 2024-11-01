<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review Detail</title>
</head>
<body>
<h1>Review Detail</h1>
<p>ID: ${review.reviewId}</p>
<p>Video ID: ${review.videoId}</p>
<p>User ID: ${review.userId}</p>
<p>Content: ${review.content}</p>
<p>Created At: ${review.createdAt}</p>
<p>Modified At: ${review.modifiedAt}</p>
<a href="review?action=updateform&reviewId=${review.reviewId}">Edit Review</a>
<a href="review?action=delete&reviewId=${review.reviewId}">Delete Review</a>
</body>
</html>