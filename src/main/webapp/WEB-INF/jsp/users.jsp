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
        <div class="col-sm-6 col-md-3">
            <p>
                <a href=" <spring:url value="/users/add" /> " class="btn btn-primary">
                    <span class="glyphicon-plus glyphicon"/></span>
                    Add new User
                </a>
            </p>
        </div>
    </div>
    <div class="row">
        <c:forEach var="user" items="${users}">
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
    <div class="row">
        <ul class="list-group">
            <c:forEach var="user" items="${users}">
                <li class="list-group-item">
                    <span class="badge">${user.age}</span>
                        ${user.firstName} ${user.lastName}
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">Panel heading</div>
        <div class="panel-body">
            <p><spring:message code="users.tableHead"/></p>
        </div>

        <!-- Table -->
        <table class="table">
            <tr>
                <th><strong>last Name</strong></th>
                <th><strong>First Name</strong></th>
                <th><strong>Username</strong></th>
                <th><strong>Age</strong></th>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.lastName}</td>
                    <td>${user.firstName}</td>
                    <td>${user.username}</td>
                    <td>${user.age}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
<jsp:include page="fragments/footerScripts.jsp"/>
</body>
</html>