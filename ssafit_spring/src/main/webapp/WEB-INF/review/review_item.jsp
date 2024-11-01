<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h3>Review by ${review.userId}</h3>
    <p>${review.content}</p>
    <a href="review?action=detail&reviewId=${review.reviewId}">Read More</a>
</body>
</html>