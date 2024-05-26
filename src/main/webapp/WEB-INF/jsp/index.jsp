<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="icon" type="image/x-icon" href="/images/icon.ico">
        <title><spring:message code="ticket" text="default"/></title>
        <link href="/css/main.css" rel="stylesheet"/>
        <script src="/js/app.js" defer></script>
    </head>
    <body>
        <header class="header">
            <div class="logo"><spring:message code="logo" text="default"/></div>
            <nav>
                <a href="#home"><spring:message code="nav_home" text="default"/></a>
                <button class="material-btn" onclick="openForm()"><spring:message code="add_game" text="default"/></button>
            </nav>
        </header>
        <form id="home" class="search-container" action="/game" method="get">
            <input type="text" class="search-box" id="search-input" name="title" placeholder=<spring:message code="tab_search" text="default"/>/>
            <button class="search-button" type="submit"><spring:message code="search" text="default"/></button>
        </form>
        <div id="smart-div">
            <div>
                <jsp:include page="../tags/messageDisplay.jsp">
                    <jsp:param name="message" value="${message}"/>
                </jsp:include>
            </div>
            <table class="game-table">
                <thead>
                    <tr>
                        <th><spring:message code="id_txt" text="default"/></th>
                        <th><spring:message code="title_txt" text="default"/></th>
                        <th><spring:message code="edit_txt" text="default"/></th>
                        <th><spring:message code="delete_txt" text="default"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="game" items="${games}">
                        <tr>
                            <td><a href="/game/${game.id}">${game.id}</a></td>
                            <td><a href="/game/${game.id}">${game.title}</a></td>
                            <td>
                                <button class="edit-btn" onclick="openEditForm(${game.id})">✏️</button>
                            </td>
                            <td>
                                <button class="delete-btn" onclick="deleteAsk(${game.id})">❌</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>