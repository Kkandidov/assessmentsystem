<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
        <h3>Вопрос: ${question}</h3>
        <table class="blueTable">
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
                <c:url var="updateLink" value="/tutor/update-answer">
                    <c:param name="id" value="${answer.id}"/>
                </c:url>

                <!-- construct an "delete" link with customer id -->
                <c:url var="deleteLink" value="/tutor/delete-answer">
                    <c:param name="id" value="${answer.id}"/>
                </c:url>

                <c:url var="createLink" value="/tutor/add-answer">
                    <c:param name="questId" value="${question.id}"/>
                </c:url>

                <tr>
                    <td>${answer.description}</td>
                    <td>${answer.correct}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Изменить</a> | <a href="${deleteLink}"
                            onclick="if (!(confirm('Точно хотите удалить?'))) return false">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


        <input type="button" class="myButton" value="Добавить ответ"
               onclick="window.location.href='${createLink}'; return false;"/>

        <input type="button" class="myButton" value="Вернуться назад"
               onclick="window.location.href='/tutor/view-questions'; return false;"/>
</div>

