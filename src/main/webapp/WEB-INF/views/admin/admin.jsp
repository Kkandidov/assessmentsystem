<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/admin/createTest'">
                Создать тест
            </button>
            <br>
            <button type="button" class="btn btn-success b"
                    onclick="location.href='${contextRoot}/admin/adminStatistic'">Статистика
            </button>
            <br>
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/admin/createUser'">
                Создать
                пользователя
            </button>
            <br>
            <button type="button" class="btn btn-danger b" onclick="location.href='${contextRoot}/logout'">Выйти
            </button>
        </div>
    </div>
</div>


