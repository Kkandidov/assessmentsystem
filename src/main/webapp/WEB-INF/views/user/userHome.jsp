<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/user/choose/test'">Выбор темы
                и теста
            </button>
            <br>
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/user/statistic'">Личная
                статисктика
            </button>
        </div>
    </div>
</div>