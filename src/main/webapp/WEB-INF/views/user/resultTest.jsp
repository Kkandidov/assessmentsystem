<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <c:if test="${resultInPercent != 100.0}">
        <table class="table">
            <p><h4 style="color: #c82333">Вы неверно ответили на вопросы: </h4></p>
            <thead>
            <tr>
                <th scope="col">Название вопроса</th>
                <th scope="col">Правильно</th>
                <th scope="col">Рекомендуемая литература</th>
                <th scope="col">Рекомендуемые ссылки на литературу</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${resultStatistic}" var="statistic">
                <tr>
                    <th scope="row">${statistic.question.description}</th>
                    <td>${statistic.correct}</td>
                    <td>
                        <c:forEach items="${statistic.question.literature}" var="literature">
                            <span>${literature.description}</span></br>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${statistic.question.literature}" var="lit">
                            <c:forEach items="${lit.links}" var="link">
                                <span><a href="#">${link.link}</a></span></br>
                            </c:forEach>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <br><br>
    <p><h4 style="color: #c82333">Тест пройден на ${resultInPercent} %</h4></p>
    <button type="button" class="btn btn-success" onclick="location.href='${contextRoot}/user/home'">На страницу
        пользователя
    </button>
</div>