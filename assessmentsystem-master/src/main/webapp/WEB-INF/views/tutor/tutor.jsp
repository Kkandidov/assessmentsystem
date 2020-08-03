<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">

            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/tutor/createTest'">
                Создать тест
            </button>
            <br>
            <button type="button" class="btn btn-success b"
                    onclick="location.href='${contextRoot}/tutor/statistic/select'">Статистика
            </button>
            <br>
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/tutor/tutor-test'">
                Редактирование тестов
            </button>
            <br>
            <button type="button" class="btn btn-danger b" onclick="location.href='${contextRoot}/logout'">Выйти
            </button>
        </div>
    </div>
</div>
