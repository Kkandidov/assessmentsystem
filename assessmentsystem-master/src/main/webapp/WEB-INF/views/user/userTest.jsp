<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>
        <div class="col-lg-6 mycont">
            <%--@elvariable id="answerModel" type="org.astashonok.assessmentsystem.model.Answer"--%>
            <sf:form modelAttribute="answerModel"
                     action="${contextRoot}/user/test"
                     method="POST">
                <div class="form-group">
                    <div class="leftal">
                        <p><h6>${question.description}</h6></p>
                    </div>
                </div>
                <div class="leftal">
                    <c:forEach items="${answers}" var="answer">
                        <div class="form-check">
                            <sf:radiobutton class="form-check-input" path="id" id="${answer.id}" value="${answer.id}"/>
                            <label class="form-check-label" for="${answer.id}">
                                    ${answer.description}
                            </label>
                        </div>
                    </c:forEach>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Следующий</button>
            </sf:form>
        </div>
    </div>
</div>