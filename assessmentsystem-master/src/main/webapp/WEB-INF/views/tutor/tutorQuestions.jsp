<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">

    <h3>Тест: ${test.name}</h3>
    <p>${test.description}</p>
    <table class="table">
        <thead>
        <tr>
            <th>Вопрос</th>
            <th>Литература</th>
            <th>Ответы</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questions}" var="question">
            <tr>
                <form:form action="/tutor/test/question/update" method="post">
                    <td>
                        <input type="hidden" name="test" value="${test.id}">
                        <input type="hidden" name="question" value="${question.id}">

                        <input required type="text" name="question-desc" class="input-group input-group-text"
                               value="${question.description}">
                    </td>
                    <td>
                        <a href="/tutor/test/${test.id}/edit/${question.id}/literature"
                           class="btn btn-light">Литература</a>
                    </td>
                    <td>
                        <a href="/tutor/test/${test.id}/answer/${question.id}" class="btn btn-light">Ответы</a>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-outline-secondary"> Изменить</button>
                        <a href="/tutor/test/${test.id}/delete/${question.id}" class="btn btn-danger"> Удалить</a>
                    </td>
                </form:form>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form:form action="/tutor/test/${test.id}/add" method="post">

        <label>Вопрос: </label>
        <input required type="text" name="quest-name" class=""/>

        <button type="submit" class="btn btn-success b">Добавить вопрос</button>
    </form:form>

    <button type="button" class="btn btn-info mt-3" onclick="location.href='${contextRoot}/tutor'">На главную</button>

</div>
