function deleteAsk(id) {
    if (confirm("Do you really want to delete this game?")) {
        fetch(`game/delete/${id}`, {method: 'DELETE'}).then((response) => {
            if (response.ok) {
                location.replace('/');
            } else {
                location.replace("/error/404");
            }
        })
    }
}

function openForm() {
    location.assign('/game/new');
}