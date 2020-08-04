<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">

    <%--@elvariable id="question" type="org.astashonok.assessmentsystem.model.Question"--%>
    <h3>Литература к вопросу: ${question.description}</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Литература</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${literature}" var="liter">
            <tr>
                <form:form action="${contextRoot}/tutor/test/literature/update" method="post">
                    <td>
                        <input type="hidden" name="test" value="${testId}">
                        <input type="hidden" name="question" value="${question.id}">
                        <input type="hidden" name="literatureId" value="${liter.id}">
                        <input required type="text" name="liter-desc" class="input-group input-group-text"
                               value="${liter.description}">
                    </td>
                    <td>
                        <button type="submit" class="btn btn-outline-secondary">Изменить</button>
                        <a href="${contextRoot}/tutor/test/${testId}/question/${question.id}/delete-literature/${liter.id}" class="btn btn-danger">
                            Удалить</a>
                    </td>
                </form:form>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form:form action="${contextRoot}/tutor/test/add-literature" method="post">
        <input type="hidden" name="test" value="${testId}">
        <input type="hidden" name="question" value="${question.id}">

        <label>Литература: </label>
        <input required type="text" name="liter-desc" class=""/>

        <button type="submit" class="btn btn-success b">Добавить литературу</button>
    </form:form>

    <input type="button" class="btn btn-info mt-3" value="Вернуться назад"
           onclick="window.location.href='${contextRoot}/tutor/test/${testId}'; return false;"/>

</div>
