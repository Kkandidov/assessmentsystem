<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="knowledge assessment system">
    <meta name="author" content="Konstantin Astashonok">

    <title>${title}</title>

    <script>
        window.contextRoot = '${contextRoot}'
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${contextRoot}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${contextRoot}/resources/css/app.css" rel="stylesheet">

</head>

<body>
<div class="wrapper">
    <!-- Navigation -->
    <%@include file="shared/navbar.jsp" %>

    <!-- Page Content -->
    <div class="text-center content">
        <c:if test="${clickedHome == true}">
            <%@include file="home.jsp" %>
        </c:if>

        <c:if test="${clickedAuthenticate == true}">
            <%@include file="login.jsp" %>
        </c:if>

        <c:if test="${errorCaused == true}">
            <%@include file="error.jsp" %>
        </c:if>

        <c:if test="${clickedUser == true}">
            <%@include file="user/userHome.jsp" %>
        </c:if>

        <c:if test="${clickedUserStatistic == true}">
            <%@include file="user/userStatistic.jsp" %>
        </c:if>

        <c:if test="${clickedChooseTest == true}">
            <%@include file="user/userChoose.jsp" %>
        </c:if>

        <c:if test="${clickedNextTest == true}">
            <%@include file="user/userTest.jsp" %>
        </c:if>

        <c:if test="${clickedResultTest == true}">
            <%@include file="user/resultTest.jsp" %>
        </c:if>

        <c:if test="${clickedChooseRole == true}">
            <%@include file="chooseRole.jsp" %>
        </c:if>

        <c:if test="${clickedAdminStatistic == true}">
            <%@include file="admin/adminStatistic.jsp" %>
        </c:if>

        <c:if test="${clickedQuestionStatistic == true}">
            <%@include file="admin/questionStatistic.jsp" %>
        </c:if>

        <c:if test="${clickedTestStatistic == true}">
            <%@include file="admin/testStatistic.jsp" %>
        </c:if>

        <c:if test="${clickedUserTestStatistic == true}">
            <%@include file="admin/userTestStatistic.jsp" %>
        </c:if>

        <c:if test="${clickedAdminPage == true}">
            <%@include file="admin/admin.jsp" %>
        </c:if>

        <c:if test="${clickedCreateTest == true}">
            <%@include file="admin/createTest.jsp" %>
        </c:if>

        <c:if test="${clickedCreateUserGet == true}">
            <%@include file="admin/createUser.jsp" %>
        </c:if>

        <c:if test="${clickedEditPage == true}">
            <%@include file="admin/editPage.jsp" %>
        </c:if>


    </div>
    <!-- Bootstrap core JavaScript -->
    <script src="${contextRoot}/resources/jquery/jquery.slim.min.js"></script>
    <script src="${contextRoot}/resources/jquery/jquery.min.js"></script>
    <script src="${contextRoot}/resources/js/bootstrap.bundle.min.js"></script>
    <script src="${contextRoot}/resources/js/app.js"></script>
</div>
</body>

</html>