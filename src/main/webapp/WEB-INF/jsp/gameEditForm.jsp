<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="ISO-8859-1">
        <title><spring:message code="ticket_edit_form" text="default"/></title>
        <link rel="icon" type="image/x-icon" href="/images/icon.ico">
        <link href="/css/gameform.css" rel="stylesheet"/>
        <script src="/js/app.js" defer></script>
    </head>
    <body>
        <div class="form-overlay" id="popupOverlay">
            <form:form method="post" action="/game/edit/${gameDto.id}" class="form" id="popup" modelAttribute="gameDto">
                <div class="form-content">
                    <p><spring:message code="editing_text" text="default"/> ${gameDto.id}</p>
                    <p><spring:message code="warning_add_game" text="default"/></p>
                    <div class="inputs">
                        <form:label path="title"><spring:message code="title_txt" text="default"/></form:label>
                        <form:input path="title"/>
                        <form:errors path="title"/>
                        <form:label path="description"><spring:message code="description_txt" text="default"/></form:label>
                        <form:input path="description"/>
                        <form:label path="steamId"><spring:message code="steamid_txt" text="default"/></form:label>
                        <form:input path="steamId"/>
                        <form:errors path="steamId"/>
                    </div>
                    <input class="form-subm" type="submit" value="<spring:message code="save_txt" text="default"/>">
                </div>
            </form:form>
        </div>
    </body>
</html>
