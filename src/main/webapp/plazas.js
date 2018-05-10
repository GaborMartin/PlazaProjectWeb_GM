function onPlazasResponse() {
    const text = this.responseText;
    const plazas = JSON.parse(text);
    const plazasContentDivEl = document.getElementById('plazas-content');

    const hEl = document.createElement('h3');
    hEl.textContent = "Plazas";


    while (plazasContentDivEl.firstChild) {
        plazasContentDivEl.removeChild(plazasContentDivEl.firstChild);
    }

    const ulEl = document.createElement('ul');

    for (let i = 0; i < plazas.length; i++) {
        const plaza = plazas[i];

        const spanEl = document.createElement('span');
        spanEl.setAttribute('id', plaza.id);
        spanEl.textContent = plaza.name;

        const liEl = document.createElement('li');
        liEl.append(spanEl);
        ulEl.append(liEl);
    }

    plazasContentDivEl.append(hEl);
    plazasContentDivEl.append(ulEl);
}

function onPlazasLoad() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPlazasResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/plazas');
    xhr.send();
}