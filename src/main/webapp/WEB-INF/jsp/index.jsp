<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Games</title>
        <link href="/css/index.css" rel="stylesheet"/>
        <script src="/js/app.js" defer></script>
    </head>
    <body>
        <div id="smart-div">
            <table class="gameTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="game" items="${games}">
                        <tr>
                            <td><a href="/game/${game.id}">${game.id}</a></td>
                            <td><a href="/game/${game.id}">${game.title}</a></td>
                            <td>
                                <button onclick="deleteAsk(${game.id})">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
