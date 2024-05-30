<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1">
        <title><spring:message code="ticket_details" text="default"/></title>
        <link rel="icon" type="image/x-icon" href="/images/icon.ico">
        <link href="/css/gamedetails.css" rel="stylesheet"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="/js/gameDetails.js" defer></script>
    </head>
    <body>
        <div class="container">
            <a class="btn-volver" href="<%= request.getContextPath() %>/"><spring:message code="return_txt" text="default"/></a>
            <div class="section">
                <form class="card-panel">
                    <jsp:include page="../tags/messageDisplay.jsp">
                        <jsp:param name="message" value="${message}"/>
                    </jsp:include>
                    <table class="highlight responsive-table">
                        <thead>
                        <tr>
                            <th><spring:message code="id_txt" text="default"/></th>
                            <th><spring:message code="title_txt" text="default"/></th>
                            <th><spring:message code="description_txt" text="default"/></th>
                            <th><spring:message code="steamid_txt" text="default"/></th>
                            <th><spring:message code="finished_txt" text="default"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="game" items="${games}">
                            <tr>
                                <td>${game.id}</td>
                                <td>${game.title}</td>
                                <td>${game.description}</td>
                                <td id="steamid">${game.steamId}</td>
                                <td><label>
                                    <input id="finishedCB" type="checkbox" value="${game.played}" onchange="updateDataBaseValueCheckBox()">
                                </label></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
            <div class="section center-align">
                <img id="gameScreenshot" class="responsive-img" alt="Game Screenshot" />
            </div>
            <div class="news_title">
                <h1><spring:message code="news_title" text="default"/></h1>
            </div>
            <div class="section">
                <h1 id="gameTitle" class="header center-align"></h1>
                <ul id="newsList" class="collection"></ul>
            </div>
        </div>
    </body>
</html>
