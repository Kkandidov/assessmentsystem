<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">


    <h3>Ссылки к литератре: ${literature.description}</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Cсылка</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${links}" var="link">
            <tr>
                <form:form action="${contextRoot}/tutor/test/link/update" method="post">
                    <td>
                        <input type="hidden" name="test" value="${testId}">
                        <input type="hidden" name="question" value="${questionId}">
                        <input type="hidden" name="literatureId" value="${literature.id}">
                        <input type="hidden" name="linkId" value="${link.id}">

                        <input required type="text" name="linkLink" class="input-group input-group-text"
                               value="${link.link}">
                    </td>
                    <td>
                        <button type="submit" class="btn btn-outline-secondary">Изменить</button>
                        <a href="${contextRoot}/tutor/test/${testId}/question/${questionId}/literature/${literature.id}/delete-link/${link.id}"
                           class="btn btn-danger" onclick="if (!(confirm('Точно хотите удалить?'))) return false">
                            Удалить</a>
                    </td>
                </form:form>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form:form action="${contextRoot}/tutor/test/add-link" method="post">
        <input type="hidden" name="test" value="${testId}">
        <input type="hidden" name="question" value="${questionId}">
        <input type="hidden" name="literature" value="${literature.id}">

        <label>Ссылка: </label>
        <input required type="text" name="link" class=""/>

        <button type="submit" class="btn btn-success b">Добавить ссылку</button>
    </form:form>

    <input type="button" class="btn btn-info mt-3" value="Вернуться к литературе"
           onclick="window.location.href='${contextRoot}/tutor/test/${testId}/literature/${questionId}'; return false;"/>

</div>
