<%--
  Created by IntelliJ IDEA.
  User: bakigoal
  Date: 09.09.15
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="fragments/staticFiles.jsp"/>
    <title>/edit user</title>
</head>
<body>
<section>
    <div class="container">
        <div class="jumbotron">
            <h1>Edit USER</h1>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="user" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Add new user</legend>
            <form:errors path="*" element="div" cssClass="error" cssStyle="width:100%;background:yellow"/>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="username">
                    <spring:message code="addProduct.form.productId.label"/>
                </label>

                <div class="col-lg-10">
                    <form:input id="username" path="username" type="text" class="form:input-large" cssErrorClass="error"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="firstName">
                    First name
                </label>

                <div class="col-lg-10">
                    <form:input id="firstName" path="firstName" type="text" class="form:input-large" cssErrorClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="lastName">
                    Last Name
                </label>

                <div class="col-lg-10">
                    <form:input id="lastName" path="lastName" type="text" class="form:input-large" cssErrorClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="age">
                    Age
                </label>

                <div class="col-lg-10">
                    <form:input id="age" path="age" type="text" class="form:input-large" cssErrorClass="error"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="sex">
                    Sex
                </label>

                <div class="col-lg-10">
                    <form:radiobutton path="sex" value="Male"/>Male
                    <form:radiobutton path="sex" value="Female"/>Female
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input name="image" type="file" cssErrorClass="error"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Edit USER"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
<jsp:include page="fragments/footerScripts.jsp"/>
</body>
</html>