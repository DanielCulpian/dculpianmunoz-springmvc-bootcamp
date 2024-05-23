<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1">
        <title><spring:message code="ticket_details" text="default"/></title>
        <link href="/css/gamedetails.css" rel="stylesheet"/>
    </head>
    <body>
        <form class="smart-form">
            <div>
                <jsp:include page="../tags/messageDisplay.jsp">
                    <jsp:param name="message" value="${message}"/>
                </jsp:include>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th><spring:message code="id_txt" text="default"/></th>
                    <th><spring:message code="title_txt" text="default"/></th>
                    <th><spring:message code="description_txt" text="default"/></th>
                    <th><spring:message code="steamid_txt" text="default"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="game" items="${games}">
                    <tr>
                        <td>${game.id}</td>
                        <td>${game.title}</td>
                        <td>${game.description}</td>
                        <td>${game.steamId}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
