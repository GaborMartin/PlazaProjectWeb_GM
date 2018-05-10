function onProductResponse() {
    const text = this.responseText;
    const product = JSON.parse(text);

    const idEl = document.getElementById('product-id');
    const nameEl = document.getElementById('product-name');
    const barcodeEl = document.getElementById('product-barcode');
    const manufacturerEl = document.getElementById('product-manufacturer');
    const priceEl = document.getElementById('product-price');

    idEl.textContent = product.id;
    nameEl.textContent = product.name;
    barcodeEl.textContent = product.barcode;
    manufacturerEl.textContent = product.manufacturer;
    priceEl.textContent = product.price;
}

function onProductClicked() {
    clearMessages();
    showContents(['profile-content', 'product-content', 'back-to-products-content', 'logout-content']);

    const productId = this.dataset.productId;

    const params = new URLSearchParams();
    params.append('id', productId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onProductResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/product?' + params.toString());
    xhr.send();
}