<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
    <div style="align-content: center">
        <img alt="Books" src="images/free-banner-png-free-download-free-png-banners-530_530.png" style="max-height: 370px">
    </div>
<h1><span>Chat App</span></h1>
<nav>
<ul>
<c:choose>
<c:when test="${param.title=='Home'}">
<li  id="actual"><a href="Controller">Home</a></li>
</c:when>
<c:otherwise>
<li><a href="Controller">Home</a></li>
</c:otherwise>
</c:choose>


</ul>
</nav>
<h2>
${param.title}
</h2>

</header>