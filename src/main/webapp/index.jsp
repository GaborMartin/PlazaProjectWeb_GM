<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <c:url value="/style.css" var="styleUrl"/>
        <c:url value="/index.js" var="indexScriptUrl"/>
        <c:url value="/login.js" var="loginScriptUrl"/>
        <c:url value="/profile.js" var="profileScriptUrl"/>
        <c:url value="/plazas.js" var="plazasScriptUrl"/>
        <c:url value="/shops.js" var="shopsScriptUrl"/>
        <c:url value="/back-to-plazas.js" var="backToPlazasScriptUrl"/>
        <c:url value="/products.js" var="productsScriptUrl"/>
        <c:url value="/product.js" var="productScriptUrl"/>
        <c:url value="/back-to-shops.js" var="backToShopsScriptUrl"/>
        <c:url value="/back-to-products.js" var="backToProductsScriptUrl"/>
        <c:url value="/logout.js" var="logoutScriptUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <script src="${indexScriptUrl}"></script>
        <script src="${loginScriptUrl}"></script>
        <script src="${profileScriptUrl}"></script>
        <script src="${plazasScriptUrl}"></script>
        <script src="${shopsScriptUrl}"></script>
        <script src="${backToPlazasScriptUrl}"></script>
        <script src="${productsScriptUrl}"></script>
        <script src="${productScriptUrl}"></script>
        <script src="${backToShopsScriptUrl}"></script>
        <script src="${backToProductsScriptUrl}"></script>
        <script src="${logoutScriptUrl}"></script>
        <title>Plaza Web</title>
    </head>
<body>

<div id="login-content" class="content">
    <h1>Login</h1>
    <form id="login-form" onsubmit="return false;">
        <input type="text" name="email">
        <input type="password" name="password">
        <button id="login-button">Login</button>
    </form>
</div>

<div id="profile-content" class="hidden content">
    <h1>Profile</h1>
    <p>Email: <span id="user-email"></span></p>
    <p>Password: <span id="user-password"></span></p>
</div>

<div id="plazas-content" class="hidden content">
</div>

<form id="plaza-form" onsubmit="return false;" class="hidden content">
    <h2>Add new plaza</h2>
    <input type="text" name="name">
    <button onclick="onPlazaAddClicked();">Add</button>
</form>

<div id ="shops-content" class="hidden content"></div>

<div id="products-content" class="hidden content"></div>

<div id="product-content" class="hidden content">
    <p>Id: <span id="product-id"></span></p>
    <p>Name: <span id="product-name"></span></p>
    <p>Barcode: <span id="product-barcode"></span></p>
    <p>Manufacturer: <span id="product-manufacturer"></span></p>
    <p>Price: <span id="product-price"></span></p>
</div>

<div id="back-to-products-content" class="hidden content">
    <button onclick="onBackToProductsClicked();">Back to products</button>
</div><br>

<div id="back-to-shops-content" class="hidden content">
    <button onclick="onBackToShopsClicked();">Back to shops</button>
</div><br>

<div id ="back-to-plazas-content" class="hidden content">
    <button onclick="onBackToPlazasClicked();">Back to plazas</button>
</div><br>

<div id="back-to-profile-content" class="hidden content">
    <br><button onclick="onBackToProfileClicked();">Back to profile</button>
</div>
<div id="logout-content" class="hidden content">
    <button id="logout-button">Logout</button>
</div>
</body>
</html>
