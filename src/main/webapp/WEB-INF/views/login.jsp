<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="login">
    <form class="form-signin" action="${contextRoot}/login" method="POST">
        <input type="text" id="inputLogin" class="form-control" name="j_login" placeholder="Логин" required autofocus>
        <input type="password" id="inputPassword" class="form-control" name="j_password" placeholder="Пароль" required>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
