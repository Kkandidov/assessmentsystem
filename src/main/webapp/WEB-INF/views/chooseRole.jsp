<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="container">
    <div class="mycont">
        <p><h1>Вы можете продолжить в качестве:</h1></p>
        <c:forEach items="${cabinets}" var="cabinet">
            <button type="button" class="btn btn-success b" onclick="location.href='${contextRoot}${cabinet.link}'">
                ${cabinet.name}
            </button>
            <br>
        </c:forEach>
    </div>
</div>
