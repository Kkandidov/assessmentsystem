<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <table class="table">
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
                        <span>${literature.description}</span></b>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${statistic.question.literature}" var="lit">
                        <c:forEach items="${lit.links}" var="link">
                            <span><a href="#">${link.link}</a></span></b>
                        </c:forEach>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <button type="button" class="btn btn-success" onclick="location.href='${contextRoot}/user/home'">На страницу
        пользователя
    </button>
</div>