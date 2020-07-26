<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>Имя пользователя</th>
            <th>Название Теста</th>
            <th>Пройдено всего раз</th>
            <th>Процент правильных ответов, %</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${statisticListUserTest}" var="statisticList">
            <tr>
                <td> ${statisticList.getFIO()}</td>
                <td> ${statisticList.getName()}</td>
                <td> ${statisticList.getCountCompleted()}</td>
                <td> ${statisticList.getPercent()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/admin'">На главную
    </button>
</div>

