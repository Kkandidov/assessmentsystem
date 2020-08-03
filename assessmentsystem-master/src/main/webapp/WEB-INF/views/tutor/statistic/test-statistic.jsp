<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>Название теста</th>
            <th>Пройдено всего</th>
            <th>Процент правильных ответов, %</th>
        </tr>
        </thead>
        <c:forEach items="${statisticListTest}" var="statisticList">
            <tr>
                <td> ${statisticList.getNameQuestion()}</td>
                <td> ${statisticList.getTotalCompleted()}</td>
                <td> ${statisticList.getPercentCorrectAnswers()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/tutor'">На главную
    </button>
</div>