<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>404 - Game Not Found</title>
        <link href="/css/404.css" rel="stylesheet"/>
    </head>
        <body>
            <div class="container">
                <div class="game-controller">🎮</div>
                <h1>404</h1>
                <h2>Game Not Found</h2>
                <p>Oops! It looks like the game you're looking for doesn't exist.</p>
                <a href="<%= request.getContextPath() %>/">Return to Home</a>
            </div>
        </body>
</html>
