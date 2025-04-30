function login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    console.log('Logging in with:', { email, password });

    fetch('http://localhost:8080/api/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
    })
        .then(res => {
            console.log('Response status:', res.status);
            if (!res.ok) throw new Error("Login failed");
            return res.json();
        })
        .then(data => {
            console.log('Login successful, data:', data);
            localStorage.setItem('token', data.token);
            localStorage.setItem('role', data.role);  // 👈 Save role
            console.log('Token stored:', localStorage.getItem('token'));
            window.location.href = "dashboard.html";
            console.log('Redirecting to dashboard.html');
        })
        .catch(err => {
            console.error('Login error:', err);
            document.getElementById("error").innerText = "Invalid login!";
        });
}

function getToken() {
    return localStorage.getItem('token');
}

function authFetch(url, options = {}) {
    const token = getToken();
    return fetch(url, {
        ...options,
        headers: {
            ...options.headers,
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    });
}

function checkAuth() {
    if (!getToken()) {
        window.location.href = "index.html";
    }
}

function logout() {
    localStorage.removeItem("token");
    window.location.href = "index.html";
}
