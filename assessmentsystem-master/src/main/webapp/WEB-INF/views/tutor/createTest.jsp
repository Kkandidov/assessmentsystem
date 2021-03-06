<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>

        <div class="col-lg-6 mycont">
            <form:form action="${contextRoot}/tutor/createTest" method="post">

                <c:if test="${not empty message and not empty testId}">
                    <div id="success" class="alert alert-success alert-dismissible fade show" role="alert">
                        <strong>${message}</strong>
                        <button type="button" class="btn btn-light"
                                onclick="location.href='${contextRoot}/tutor/test/${testId}'">Редактировать
                        </button>
                        <script>
                            setTimeout(function () {
                                document.getElementById("success").style.display = 'none';
                            }, 6000)
                        </script>
                    </div>
                </c:if>

                <div class="form-group">
                    <select required class="form-control" id="topicId" name="topicId">
                        <option value="" disabled selected>Выберите тему</option>
                        <c:forEach items="${topics}" var="topic">
                            <option value="${topic.id}">${topic.name}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <input required name="test-name" type="text" class="form-control" placeholder="Название теста"/>
                    <textarea required name="test-description" type="text" class="form-control mt-3"
                              placeholder="Описание теста"></textarea>
                </div>

                <input type="submit" class="btn btn-success b" value="Создать тест">

                <button type="button" class="btn btn-danger " onclick="location.href='${contextRoot}/tutor'">
                    На главную
                </button>

            </form:form>
        </div>

    </div>

</div>