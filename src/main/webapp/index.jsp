<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <c:url value="/style.css" var="styleUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <script src="${indexScriptUrl}"></script>

        <title>Plaza</title>
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
    <h2>Links</h2>
    <ul>
        <li><a href="javascript:void(0);" onclick="onShopsClicked();">Shops</a></li>
        <li><a href="javascript:void(0);" onclick="onCouponsClicked();">Coupons</a></li>
    </ul>
</div>
<div id="plazas-content" class="hidden content">
    <h1>Plazas</h1>
    <table id="plazas">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
<div id="back-to-profile-content" class="hidden content">
    <button onclick="onBackToProfileClicked();">Back to profile</button>
</div>
<div id="logout-content" class="hidden content">
    <button id="logout-button">Logout</button>
</div>
</div>
</body>
</html>
