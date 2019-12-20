<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>${param.title } | Chat App</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src='js/jquery-ui.min.js'></script>
    <script src="js/chat.js"></script>
    <script src="js/messages.js"></script>
    <c:if test="${!param.title.equals(\"Chat\")}">
        <script src="js/blog.js"></script>
    </c:if>
    <link rel="stylesheet" type="text/css" href="css/sample.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
