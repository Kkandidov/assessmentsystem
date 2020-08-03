<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Фамилия и имя пользователя</th>
            <th scope="col">Название теста</th>
            <th scope="col">Формулировка вопросв</th>
            <th scope="col">Пройдено всего</th>
            <th scope="col">Процент правильно пройденных вопросов</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userStatistic}" var="statistic">
            <tr>
                <th scope="row">${statistic.fullName}</th>
                <td>${statistic.testName}</td>
                <td>${statistic.questionDescription}</td>
                <td>${statistic.passedTimes}</td>
                <td>${statistic.correctAnswersPercentage}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <button type="button" class="btn btn-success" onclick="location.href='${contextRoot}/user/home'">На страницу
        пользователя
    </button>
</div>