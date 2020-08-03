<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/admin/testStatistic'">
                Статистика по тесту
            </button>
            <br>
            <button type="button" class="btn btn-success b"
                    onclick="location.href='${contextRoot}/admin/questionStatistic'">Статистика по вопросам
            </button>
            <br>
            <button type="button" class="btn btn-success b"
                    onclick="location.href='${contextRoot}/admin/userTestStatistic'">Статистика по пользователям
            </button>
            <br>
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/admin'">Назад
            </button>
        </div>
    </div>
</div>



