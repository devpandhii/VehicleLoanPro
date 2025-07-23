document.addEventListener('DOMContentLoaded', function () {
    fetch('navbar.html')
        .then(response => response.text())
        .then(html => {
            const temp = document.createElement('div');
            temp.innerHTML = html;
            const navbar = temp.querySelector('nav');
            document.body.insertBefore(navbar, document.body.firstChild);

            updateAuthLinks(); // Call after navbar is loaded
        });

    function updateAuthLinks() {
        const authLinks = document.getElementById('authLinks');
        const currentUser = JSON.parse(localStorage.getItem('currentUser'));

        if (currentUser) {
            authLinks.innerHTML = `
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="logout()">
                        <i class="fas fa-sign-out-alt me-1"></i>Logout
                    </a>
                </li>
            `;
        } else {
            authLinks.innerHTML = `
                <li class="nav-item">
                    <a class="nav-link" href="login.html">
                        <i class="fas fa-sign-in-alt me-1"></i>Login
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="signup.html">
                        <i class="fas fa-user-plus me-1"></i>Sign Up
                    </a>
                </li>
            `;
        }
    }

    window.logout = function () {
        localStorage.removeItem('currentUser');
        window.location.href = 'index.html';
    };
});