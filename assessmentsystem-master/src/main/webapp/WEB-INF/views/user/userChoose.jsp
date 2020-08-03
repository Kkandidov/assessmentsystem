<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <c:if test="${not empty message}">
        <div id="message" class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>${message}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <div class="form-group">
                <select class="form-control" id="themes" name="themes">
                    <option value="" disabled selected>Выберите тему</option>
                    <c:forEach items="${topics}" var="topic">
                        <option value="${topic.id}">${topic.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <select class="form-control" id="testNames" name="testName">
<%--                    <option>Выберите тест</option>--%>
<%--                    <c:forEach items="${tests}" var="test">--%>
<%--                        <option value="${test.id}">${test.name}</option>--%>
<%--                    </c:forEach>--%>
                </select>
            </div>
            <button type="button" class="btn btn-primary" id="testId">Пройти тестирование</button>
        </div>
    </div>
</div>