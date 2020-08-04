<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home"><img src="${contextRoot}/resources/images/home/home.png"
                                                                width="91"
                                                                height="32"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item" id="mainBar">
                    <a class="nav-link" href="${contextRoot}/home">Главная</a>
                </li>
                <security:authorize access="isAnonymous()">
                    <li class="nav-item" id="authenticationBar">
                        <a class="nav-link" href="${contextRoot}/login">Войти</a>
                    </li>
                </security:authorize>
                <ul class="navbar-nav ml-right">
                    <security:authorize access="isAuthenticated()">
                        <li class="nav-item" id="chooseRole">
                            <a class="nav-link" href="${contextRoot}/choose/role">Выбрать роль</a>
                        </li>
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${userDto.fullName}
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="${contextRoot}/logout">Выйти</a>
                            </div>
                        </div>
                    </security:authorize>
                </ul>
            </ul>
        </div>
    </div>
</nav>