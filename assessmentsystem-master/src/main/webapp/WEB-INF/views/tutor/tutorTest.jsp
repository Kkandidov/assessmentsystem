<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container ">

    <div>
        <c:if test="${not empty message}">
            <div id="message" class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>${message}</strong>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>


        <select required class="form-control mb-3" id="topics">
            <option value="" disabled selected>Выберите тему</option>
            <c:forEach items="${topics}" var="topic">
                <option value="${topic.id}">${topic.name}</option>
            </c:forEach>
        </select>

        <select required class="form-control" id="tests" name="tests">
        </select>

        <button type="button" id="test" class="btn btn-success b mt-3">Редактировать тест</button>
    </div>
    <button type="button" class="btn btn-danger b" onclick="location.href='${contextRoot}/tutor'">На главную</button>
</div>