<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <button type="button" class="btn btn-success b"
                    onclick="location.href='${contextRoot}/tutor/statistic/user-statistic'">
                Статистика пользователей
            </button>
            <br>
            <button type="button" class="btn btn-success b"
                    onclick="location.href='${contextRoot}/tutor/statistic/test-statistic'">
                Статистика по тестам
            </button>
            <br>
            <button type="button" class="btn btn-danger b"
                    onclick="location.href='${contextRoot}/tutor'">На главную
            </button>
        </div>
    </div>
</div>
