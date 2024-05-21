<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1">
        <title>Game Form</title>
        <link href="/css/gameform.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="form-overlay" id="popupOverlay">
            <form onsubmit="location.reload()" method="post" action="/game/new" class="form" id="popup">
                <div class="form-content">
                    <p>Add a new Game</p>
                    <p>Please, specify all the arguments!</p>
                    <div class="inputs">
                        <input name="title" type="text" placeholder="Title" id="title-input" required="required">
                        <input name="description" type="text" placeholder="Description" id="description-input" required="required">
                        <input name="steamId" type="number" placeholder="Steam ID" id="number-input" required="required">
                    </div>
                    <input class="form-subm" type="submit" value="Save">
                </div>
            </form>
        </div>
    </body>
</html>
