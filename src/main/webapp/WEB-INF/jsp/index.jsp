<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Games</title>
    </head>
    <body>
        <form class="smart-form">
            <table class="tb-regist" id="eeMsg">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="game" items="${games}">
                        <tr>
                            <td>${game.id}</td>
                            <td>${game.title}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    <body>
</html>