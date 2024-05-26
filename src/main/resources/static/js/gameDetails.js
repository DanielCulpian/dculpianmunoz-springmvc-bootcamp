$(document).ready(function() {
    const gameId = getGameIdFromURL();

    console.log(gameId);

    if (gameId) {
        $.ajax({
            url: `/game/steam/details/${gameId}`,
            method: 'GET',
            success: function(imageUrl) {
                renderGameDetails(imageUrl);
            }
        });

        $.ajax({
            url: `/game/steam/news/${gameId}`,
            method: 'GET',
            success: function(newsItems) {
                renderNewsItems(newsItems);
            }
        });
    } else {
        console.error('Game ID not found in the URL');
    }
});

function getGameIdFromURL() {
        var tdElement = document.getElementById("steamid");

        var tdText = tdElement.innerText || tdElement.textContent;

        console.log(tdText);

        return tdText;
}

function renderGameDetails(imageUrl) {
    $('#gameScreenshot').attr('src', imageUrl);
}

function renderNewsItems(newsItems) {
    const newsList = $('#newsList');
    newsItems.forEach(item => {
        const newsItem = $('<li></li>');
        const newsLink = $('<a></a>').attr('href', item.url).attr('target', '_blank').text(item.title);
        const newsContent = $('<p></p>').html(item.contents); // Usar html() en lugar de text()
        const newsAuthor = $('<p></p>').text(`By: ${item.author}`);
        newsItem.append(newsLink, newsContent, newsAuthor);
        newsList.append(newsItem);
    });
}

