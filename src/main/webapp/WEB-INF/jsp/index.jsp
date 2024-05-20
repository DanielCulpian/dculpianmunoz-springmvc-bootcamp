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
        <header class="header">
            <div class="logo">Steam Games</div>
            <nav>
                <a href="#home">Home</a>
                <button class="material-btn">Add New Game</button>
            </nav>
        </header>
        <form id="home" class="search-container" action="/game" method="get">
            <input type="text" class="search-box" id="search-input" name="title" placeholder="Search by title...">
            <button class="search-button" type="submit">Search</button>
        </form>
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
                                <button class="delete-btn" onclick="deleteAsk(${game.id})">❌</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>