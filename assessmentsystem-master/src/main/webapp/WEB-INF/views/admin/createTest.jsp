<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <div class="row">
        <div class="col-lg-6 mycont">
            <%@include file="../shared/sidebar.jsp" %>
        </div>

        <div class="col-lg-6 mycont">
            <form:form action="${contextRoot}/admin/createTest" method="post">
                <p id="success">${message}</p>
                <script>
                    setTimeout(function () {
                        document.getElementById("success").style.display = 'none';
                    }, 6000)
                </script>

                <div class="form-group">
                    <input required name="topic" type="text" class="form-control" placeholder="Название темы"/>
                    <textarea required name="description" type="text" class="form-control mt-3" placeholder="Описание темы"></textarea>
                </div>

                <input type="submit" class="btn btn-success b" value="Создать тему">

                <button type="button" class="btn btn-danger " onclick="location.href='${contextRoot}/admin'">
                    На главную
                </button>

            </form:form>
        </div>

    </div>

</div>