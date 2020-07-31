<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <h3>Вопрос: ${question.description}</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Ответ</th>
            <th>Верный</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${answers}" var="answer">
            <!-- construct an "update" link with customer id -->
            <%--            <c:url var="updateLink" value="/tutor/update-answer">--%>
            <%--                <c:param name="id" value="${answer.id}"/>--%>
            <%--            </c:url>--%>

            <c:url var="deleteLink" value="/tutor/test/delete-answer">
                <c:param name="answer" value="${answer.id}"/>
                <c:param name="test" value="${testId}"/>
                <c:param name="question" value="${question.id}"/>
            </c:url>

            <tr>
                <td>${answer.description}</td>
                <td>${answer.correct}</td>
                <td>
                    <a href="${updateLink}">Изменить</a> | <a methods="post" href="${deleteLink}"
                                                              onclick="if (!(confirm('Точно хотите удалить?'))) return false">Удалить</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form:form action="/tutor/test/${testId}/edit/${question.id}/add" method="post">

        <label>Ответ: </label>
        <input type="text" name="answer-desc" cssClass="css-input"/>

        <label>Корректен? </label>
<%--        <input type="text" name="isCorrect" cssClass="css-input"/>--%>

        <select class="css-input" name="isCorrect">
            <option value="false">Нет</option>
            <option value="true">Да</option>
        </select>

        <button type="submit" class="btn btn-success b">Добавить ответ</button>
    </form:form>

    <input type="button" class="btn btn-danger b" value="Вернуться назад"
           onclick="window.location.href='/tutor/test/${testId}'; return false;"/>
</div>

