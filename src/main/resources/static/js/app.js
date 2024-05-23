function deleteAsk(id) {
    if (confirm("Do you really want to delete this game?")) {
        fetch(`game/delete/${id}`, {method: 'DELETE'}).then((response) => {
            if (response.ok) {
                alert("Game was deleted successfully!");
                location.replace('/');
            }  else if(response.status === 404) {
                location.replace("/error/404");
            }
        })
    }
}

function openForm() {
    location.assign('/game/new');
}

function openEditForm(id) {
    location.replace(`/game/edit/${id}`)
}