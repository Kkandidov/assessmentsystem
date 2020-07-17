<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6">
            <div class="form-group">
                <select class="form-control" id="themes" name="themes">
                    <option>Выберите тему</option>
                    <c:forEach items="${topics}" var="topic">
                        <option value="${topic.id}">${topic.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <select class="form-control" id="testNames" name="testName">
                    <option>Выберите тест</option>
                    <c:forEach items="${tests}" var="test">
                        <option value="${test.id}">${test.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="button" class="btn btn-primary" id="testId">Пройти тестирование</button>
        </div>
    </div>
</div>