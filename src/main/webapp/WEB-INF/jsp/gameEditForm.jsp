<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1">
        <title>Game Edit Form</title>
        <link href="/css/gameform.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="form-overlay" id="popupOverlay">
            <form:form onsubmit="location.reload()" method="post" action="/game/edit/${game.id}" class="form" id="popup" modelAttribute="game">
                <div class="form-content">
                    <p>Editing Game: ${game.id}</p>
                    <p>Please, specify all the arguments!</p>
                    <div class="inputs">
                        <label>Title</label>
                        <form:input path="title"/>
                        <label>Description</label>
                        <form:input path="description"/>
                        <label>Steam Id</label>
                        <form:input path="steamId"/>
                    </div>
                    <input class="form-subm" type="submit" value="Save">
                </div>
            </form:form>
        </div>
    </body>
</html>
