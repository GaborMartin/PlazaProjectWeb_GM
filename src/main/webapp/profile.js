function onProfileLoad(user) {
    clearMessages();
    showContents(['profile-content', 'logout-content', 'plazas-content', 'plaza-form']);

    const userEmailSpandEl = document.getElementById('user-email');
    const userPasswordSpanEl = document.getElementById('user-password');

    userEmailSpandEl.textContent = user.email;
    userPasswordSpanEl.textContent = user.password;

    onPlazasLoad();
}
