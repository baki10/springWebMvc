<%--
  Created by IntelliJ IDEA.
  User: bakigoal
  Date: 08.09.15
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="fragments/staticFiles.jsp"/>
    <title>Friends</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <jsp:include page="fragments/bodyHeader.jsp"/>
            <h1>Friends</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach var="user" items="${friends}">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                    <div class="caption">
                        <h3>${user.firstName}</h3>

                        <p>${user.lastName}</p>
                        <c:if test="${not empty user.imageUrl}">
                            <div class="thumbnail">
                                <img style="width: 100%" src="<c:url value="/resources/images/${user.imageUrl}"/>" alt="">
                            </div>
                        </c:if>
                        <p>${user.age}</p>

                        <p>
                            <a href=" <spring:url value="/users/${user.username}" /> " class="btn btn-info" role="button">
                                User profile
                            </a>
                            <form action=" <spring:url value="/users/remove" /> " method="POST" >
                                <input type="hidden" name="username" value="${user.username}"/>
                                <button type="submit" class="btn btn-danger">
                                    <i class="glyphicon glyphicon-remove"></i>
                                    Delete user
                                </button>
                            </form>
                        </p>
                    </div>
            </div>
        </c:forEach>
    </div>
</section>
<jsp:include page="fragments/footerScripts.jsp"/>
</body>
</html>