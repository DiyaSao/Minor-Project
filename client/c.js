function login() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    if (username === 'user' && password === 'password') {
        document.querySelector('.login-container').classList.add('hidden');
        document.getElementById('dashboard').classList.remove('hidden');
        document.getElementById('welcomeText').innerText = 'Welcome, ' + username;
    } else {
        alert('Invalid username or password');
    }
}

function logout() {
    document.getElementById('dashboard').classList.add('hidden');
    document.querySelector('.login-container').classList.remove('hidden');
    document.getElementById('loginForm').reset();
}