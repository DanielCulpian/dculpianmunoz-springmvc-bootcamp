function deleteAsk(id) {
    if (confirm("Do you really want to delete this game?")) {
        fetch(`game/delete/${id}`, {method: 'DELETE'}).then((response) => {
            if (response.ok) {
                location.replace('/')
            } else {
                location.replace("/error/404")
            }
        })
    }
}

const popupOverlay = document.getElementById('popupOverlay');
const closePopup = document.getElementById('closePopup');

function openPopup() {
    popupOverlay.style.display = 'block';
}

function closePopupFunc() {
    popupOverlay.style.display = 'none';
}

closePopup.addEventListener('click', closePopupFunc);

popupOverlay.addEventListener('click', function (event) {
    if (event.target === popupOverlay) {
        closePopupFunc();
    }
});
