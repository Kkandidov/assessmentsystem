<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <c:url value="${contextRoot}/admin/edit" var="var"/>
            <%--@elvariable id="user" type="org.astashonok.assessmentsystem.model.User"--%>
            <form:form action="${var}" method="POST" modelAttribute="user">
                <input class="css-input" type="hidden" name="id" value="${user.id}">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Имя" id="firstName" value="${user.firstName}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Фамилия" id="lastName"
                           value="${user.lastName}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Логин" id="login">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Пароль" id="password">
                </div>
                <div class="form-group">
                    <form:select path="nameRole" class="form-control">
                        <form:options items="${allRoles}"/>
                    </form:select>
                </div>
                <button type="submit" class="btn btn-primary">Изменить</button>
            </form:form>
        </div>
    </div>
</div>
