<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video Player</title>
</head>
<body>
<h1>Playing Video: ${video.title}</h1>
<video width="600" controls>
    <source src="${video.url}" type="video/mp4">
    Your browser does not support the video tag.
</video>
</body>
</html>