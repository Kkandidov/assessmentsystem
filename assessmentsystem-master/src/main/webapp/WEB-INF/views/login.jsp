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
    <c:if test="${not empty logout}">
        <div id="logout" class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>${logout}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <form class="form-signin" action="${contextRoot}/login" method="POST">
        <img class="mb-4" src="${contextRoot}/resources/images/login.jpg" alt="" width="72"
             height="72">
        <h1 class="h3 mb-3 font-weight-normal">Пожалуйста войдите</h1>
        <input type="text" id="inputLogin" class="form-control" name="j_login" placeholder="Логин" required
               autofocus>
        <input type="password" id="inputPassword" class="form-control" name="j_password"
               placeholder="Пароль"
               required>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2020</p>
    </form>
</div>
