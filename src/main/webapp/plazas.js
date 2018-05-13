let ulEl;

function onPlazaAddResponse() {
    clearMessages();
    if (this.status === OK) {
        appendPlaza(JSON.parse(this.responseText));
    } else {
        onOtherResponse(plazasContentDivEl, this);
    }
}

function onPlazaAddClicked() {
    const plazaFormEl = document.forms['plaza-form'];

    const nameInputEl = plazaFormEl.querySelector('input[name="name"]');

    const name = nameInputEl.value;

    const params = new URLSearchParams();
    params.append('name', name);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPlazaAddResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'protected/plazas');
    xhr.send(params);
}

function onPlazasResponse() {
    const text = this.responseText;
    const plazas = JSON.parse(text);
    const plazasContentDivEl = document.getElementById('plazas-content');

    const hEl = document.createElement('h3');
    hEl.textContent = "Plazas";

    /*
    while (plazasContentDivEl.firstChild) {
        plazasContentDivEl.removeChild(plazasContentDivEl.firstChild);
    } */

    plazasContentDivEl.append(hEl);
    plazasContentDivEl.append(createPlazasList(plazas));
}

function createPlazasList(plazas) {
    ulEl = document.createElement('ul');

    for (let i = 0; i < plazas.length; i++) {
        const plaza = plazas[i];
        appendPlaza(plaza);
    }
    return ulEl;
}

function onPlazaRemoveResponse() {
    removeAllChildren(plazasContentDivEl);
    onPlazasLoad();
}

function onDeleteButtonClicked() {
    clearMessages();

    const plazaId = this.dataset.plazaId;

    const params = new URLSearchParams();
    params.append('id', plazaId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPlazaRemoveResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('DELETE', 'protected/plazas?' + params.toString());
    xhr.send();
}

function appendPlaza(plaza) {
    const spanEl = document.createElement('span');
    spanEl.setAttribute('id', plaza.id);
    spanEl.textContent = plaza.name;
    spanEl.dataset.plazaId = plaza.id;
    const deleteButton = document.createElement('button');
    deleteButton.dataset.plazaId = plaza.id;
    deleteButton.textContent = 'Delete!';

    spanEl.addEventListener('click', onPlazaClicked);
    deleteButton.addEventListener('dblclick', onDeleteButtonClicked);

    const liEl = document.createElement('li');
    liEl.append(spanEl);
    liEl.append(deleteButton);
    ulEl.append(liEl);
}

function onPlazasLoad() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPlazasResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/plazas');
    xhr.send();
}