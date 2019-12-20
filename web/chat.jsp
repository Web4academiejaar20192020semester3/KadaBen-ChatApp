<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>

<body onload="ready()">

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>

<main>

    <c:if test="${errors.size() > 0}">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <c:choose>
        <c:when test="${user!=null}">
            <p>Welcome ${user.getFirstName()} ${user.getLastName()}!</p>
            <br>
            <br>
            <br>
            <table id="friends">

            </table>
            <p id="currentstatus">Status: </p>
            <p>Change status</p>
            <p id="statusform">
                <input type="text" id="newstatus" placeholder="eg. Busy">
                <input type="button" id="changestatusbutton" value="Change">
            </p>
            <br>
            <br>
            <p>Add Friends</p>
            <p id="addfriendform">
                <input type="text" id="addfriendemail" placeholder="Enter your friend's e-mail">
                <input type="button" id="addfriendbutton" value="Add">
            </p>

            <div class="messagesContainer" id="messagesContainer">

            </div>

        </c:when>
    </c:choose> </main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>

</body>
</html>