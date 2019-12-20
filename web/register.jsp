<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat" />
</jsp:include>

<body>

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

            <form action="Controller?action=RegisterUser" method="post">
                <p>Voornaam</p>
                <input type="text" name="firstname">

                <p>Achternaam</p>
                <input type="text" name="lastname">

                <p>E-mail</p>
                <input type="text" name="email">

                <p>Wachtwoord</p>
                <input type="text" name="password">

                <p>Herhaal wachtwoord</p>
                <input type="text" name="passwordRepeat">

                <p>Geslacht</p>
                <input type="radio" name="gender" value="male">Male<br>
                <input type="radio" name="gender" value="female">Female<br>
                <input type="radio" name="gender" value="other">Other

                <p>Leeftijd</p>
                <input type="text" name="age">
                
                <p>Register User</p>
                <input type="submit">
            </form>


</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>

</body>
</html>