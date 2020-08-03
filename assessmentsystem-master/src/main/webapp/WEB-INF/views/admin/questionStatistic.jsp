<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>Формулировка вопроса</th>
            <th>Пройдено всего</th>
            <th>Процент правильных вопросов, %</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${statisticListQuestion}" var="statisticList">
            <tr>
                <td> ${statisticList.getNameQuestion()}</td>
                <td> ${statisticList.getTotalCompleted()}</td>
                <td> ${statisticList.getPercentCorrectAnswers()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/admin'">На главную
    </button>
</div>





