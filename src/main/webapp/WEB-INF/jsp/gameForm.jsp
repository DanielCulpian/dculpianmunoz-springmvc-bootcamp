<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1">
        <title>Game Form</title>
        <link href="/css/gameform.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="form-overlay" id="popupOverlay">
            <form:form onsubmit="location.reload()" method="post" action="/game/new" class="form" id="popup" modelAttribute="gameDto">
                <div class="form-content">
                    <p>Add a new Game</p>
                    <p>Please, specify all the arguments!</p>
                    <div class="inputs">
                        <form:label path="title">Title</form:label>
                        <form:input path="title"/>
                        <form:errors path="title"/>
                        <form:label path="description">Description</form:label>
                        <form:input path="description"/>
                        <form:label path="steamId">Steam Id</form:label>
                        <form:input path="steamId"/>
                        <form:errors path="steamId"/>
                    </div>
                    <input class="form-subm" type="submit" value="Save">
                </div>
            </form:form>
        </div>
    </body>
</html>
