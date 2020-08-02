<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <form action="${contextRoot}/saveNewQuestion">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Название темы" list="topics" id="topic" name="topic">
                    <datalist id="topics" name="nameTopic">
                        <c:forEach items="${topics}" var="topic">
                            <option value="${topic}">
                        </c:forEach>
                    </datalist>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Название теста" list="testts" id="testt" name="testt">
                    <datalist id="testts">
                        <c:forEach items="${tests}" var="test">
                            <option value="${test}"/>
                        </c:forEach>
                    </datalist>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Название вопроса" list="questions" id="question"
                           name="question">
                    <datalist id="questions">
                        <c:forEach items="${questions}" var="question">
                            <option value="${question}"/>
                        </c:forEach>
                    </datalist>
                </div>
                <button type="submit" class="btn btn-primary">Создать</button>
            </form>
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}/admin'">Назад
            </button>
            <p id="success"><a style="color:green;font-size:120%;">${success}</a></p>
            <script>
                setTimeout(function () {
                    document.getElementById("success").style.display = 'none';
                }, 6000)
            </script>
        </div>
    </div>
</div>