<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="/images/icon.ico">
        <title><spring:message code="ticket_404" text="default"/></title>
        <link href="/css/404.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <div class="game-controller">🎮</div>
            <h1>404</h1>
            <h2><spring:message code="not_found_txt" text="default"/></h2>
            <p><spring:message code="error_msg" text="default"/></p>
            <a href="<%= request.getContextPath() %>/"><spring:message code="return_txt" text="default"/></a>
        </div>
    </body>
</html>
