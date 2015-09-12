
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
    <title>Users</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Users</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach var="user" items="${users}">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${user.firstName}</h3>

                        <p>${user.lastName}</p>

                        <p>${user.age}</p>

                        <p>
                            <a href=" <spring:url value="/users/id/${user.id}" /> " class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span>
                                User profile
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<jsp:include page="fragments/footerScripts.jsp"/>
</body>
</html>