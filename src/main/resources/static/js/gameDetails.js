$(document).ready(function() {
    updateCheckBox();
    const gameId = getGameId();

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

function getGameId() {
        var tdElement = document.getElementById("steamid");

        var tdText = tdElement.innerText || tdElement.textContent;

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

function updateCheckBox(){
    var checkBox = document.getElementById('finishedCB');

    checkBox.checked = checkBox.value === 'true';
}

function updateDataBaseValueCheckBox(){
    var url = window.location.href;

    var id = url.match(/\/(\d+)$/)[1];

    const request = '/game/editPlayed/' + id;

    fetch(request, {
        method: 'GET'
    })
        .then(response => {
                location.replace(url);
        })

}