<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="mycont">
    <div class="margin-top185">
        <%--@elvariable id="answer" type=""--%>
        <form:form action="/tutor/save-answer" method="post" modelAttribute="answer">

            <!-- need to associate this data with customer id -->
            <form:hidden path="id"/>
            <form:hidden path="question.id"/>

            <label for="description">Ответ: </label> <br>

            <form:input path="description" cssClass="css-input"/>
            <br>
            <label for="correct">Коректен?</label> <br>
            <form:input path="correct" cssClass="css-input"/>
            <br>
            <form:button>Submit</form:button>
        </form:form>
    </div>
</div>
