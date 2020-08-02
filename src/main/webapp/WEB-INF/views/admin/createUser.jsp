<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <%--@elvariable id="user" type="org.astashonok.assessmentsystem.model.User"--%>
            <form:form method="post" action="${contextRoot}/admin/createUser" name="user" modelAttribute="user">
                <div class="form-group">
                    <form:select path="nameRoles" class="form-control">
                        <form:options items="${allRoles}"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <form:input path="lastName" type="text" class="form-control" placeholder="Фамилия"/>
                </div>
                <div class="form-group">
                    <form:input path="firstName" type="text" class="form-control" placeholder="Имя"/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Отчество"/>
                </div>
                <div class="form-group">
                    <form:input path="password" type="password" class="form-control" placeholder="Пароль"/>
                </div>
                <div class="form-group">
                    <form:input path="login" type="text" class="form-control" placeholder="Логин"/>
                </div>
                <%--                <div class="form-group">--%>
                <%--                    <form:input path="email" type="text" class="form-control" placeholder="yourmail@gmail.com"/>--%>
                <%--                </div>--%>
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </form:form>
        </div>
    </div>

    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Роли</th>
                <th>Действие</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getNameRole()}</td>
                    <td>
                        <a href="${contextRoot}/admin/edit/${user.id}" style="text-decoration: none">Изменить</a>
                        <a href="${contextRoot}/admin/delete/${user.id}" style="text-decoration: none">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="mycont">
        <p id="success"><a style="color:green;font-size:120%;">${success}</a></p>
        <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/admin'">Назад</button>
    </div>

    <script>
        setTimeout(function () {
            document.getElementById("success").style.display = 'none';
        }, 6000)
    </script>
</div>
