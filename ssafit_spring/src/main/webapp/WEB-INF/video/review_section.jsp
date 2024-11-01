<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Reviews</h2>
<c:forEach var="review" items="${reviewList}">
    <jsp:include page="/WEB-INF/review/review_item.jsp">
        <jsp:param name="review" value="${review}"/>
    </jsp:include>
</c:forEach>
</body>
</html>