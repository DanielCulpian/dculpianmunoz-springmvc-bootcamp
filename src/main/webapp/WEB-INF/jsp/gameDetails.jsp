<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1">
        <title>Game Details</title>
        <link href="/css/gameDetails.css" rel="stylesheet"/>
    </head>
    <body>
        <form class="smart-form">
            <table class="table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Steam ID</th>
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
