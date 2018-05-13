shopsContentDivEl;
function onShopsResponse() {
    clearMessages();
    if (this.status === OK) {
        const text = this.responseText;
        const shops = JSON.parse(text);
        const shopsContentDivEl = document.getElementById('shops-content');

        const hEl = document.createElement('h3');
        hEl.textContent = "Shops in plaza";

        while (shopsContentDivEl.firstChild) {
            shopsContentDivEl.removeChild(shopsContentDivEl.firstChild);
        }

        const ulEl = document.createElement('ul');

        for (let i = 0; i < shops.length; i++) {
            const shop = shops[i];

            const spanEl = document.createElement('span');
            spanEl.setAttribute('id', shop.id);
            spanEl.textContent = shop.name;
            spanEl.dataset.shopId = shop.id;

            spanEl.addEventListener('click', onShopClicked);

            const liEl = document.createElement('li');
            liEl.append(spanEl);
            ulEl.append(liEl);
        }

            shopsContentDivEl.append(hEl);
            shopsContentDivEl.append(ulEl);
    } else {
        removeAllChildren(shopsContentDivEl);
        onOtherResponse(shopsContentDivEl, this);
    }
}
/*
function onShopsLoad() {
    const plazaId = this.dataset.plazaId;

    const params = new URLSearchParams();
    params.append('id', plazaId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onShopsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/shops');
    xhr.send();
} */

function onPlazaClicked() {
    clearMessages();
    showContents(['profile-content', 'logout-content', 'shops-content', 'back-to-plazas-content']);

    const plazaId = this.dataset.plazaId;

    const params = new URLSearchParams();
    params.append('id', plazaId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onShopsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/shops?' + params.toString());
    xhr.send();
}
