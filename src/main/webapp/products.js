function onProductsResponse() {
    const text = this.responseText;
    const products = JSON.parse(text);
    const productsContentDivEl = document.getElementById('products-content');

    const hEl = document.createElement('h3');
    hEl.textContent = "Products in shop";

    while (productsContentDivEl.firstChild) {
        productsContentDivEl.removeChild(productsContentDivEl.firstChild);
    }

    const ulEl = document.createElement('ul');

    for (let i = 0; i < products.length; i++) {
        const product = products[i];

        const spanEl = document.createElement('span');
        spanEl.setAttribute('id', product.id);
        spanEl.textContent = product.name;
        spanEl.dataset.productId = product.id;

        spanEl.addEventListener('click', onProductClicked);

        const liEl = document.createElement('li');
        liEl.append(spanEl);
        ulEl.append(liEl);
    }

    productsContentDivEl.append(hEl);
    productsContentDivEl.append(ulEl);
}

function onShopClicked() {
    clearMessages();
    showContents(['profile-content', 'products-content', 'back-to-shops-content', 'logout-content']);

    const shopId = this.dataset.shopId;

    const params = new URLSearchParams();
    params.append('id', shopId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onProductsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/products?' + params.toString());
    xhr.send();
}