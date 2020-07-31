<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">

    <h3>Тест: ${test.name}</h3>
    <p>${test.description}</p>
    <table class="table">
        <thead>
        <tr>
            <th>Вопрос</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>${question.description}</td>
                <td>
                    <a href="/tutor/test/${test.id}/edit/${question.id}" style="text-decoration: none">Изменить</a>
                    <a href="/tutor/test/${test.id}/delete/${question.id}" style="text-decoration: none">Удалить</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form:form action="/tutor/test/${test.id}/add" method="post">

        <label>Вопрос: </label>
        <input type="text" name="quest-name" cssClass="css-input"/>

        <button type="submit" class="btn btn-success b">Добавить вопрос</button>
    </form:form>

    <button type="button" class="btn btn-danger b" onclick="location.href='${contextRoot}/tutor'">На главную</button>

</div>
