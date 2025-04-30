const content = document.getElementById('content');

function navigateTo(page) {
    switch (page) {
        case 'dashboard':
            content.innerHTML = '<h2>Dashboard</h2><p>Welcome!</p>';
            break;
        case 'students':
            content.innerHTML = '<h2>Students</h2>';
            break;
        case 'teachers':
            content.innerHTML = '<h2>Teachers</h2>';
            break;
        case 'grades':
            content.innerHTML = '<h2>Grades</h2>';
            break;
        default:
            content.innerHTML = '<h2>Page not found</h2>';
    }
}

// Example: create simple nav links dynamically
const sideMenu = document.getElementById('side-menu');
sideMenu.innerHTML = `
    <button onclick="navigateTo('dashboard')">Dashboard</button>
    <button onclick="navigateTo('students')">Students</button>
    <button onclick="navigateTo('teachers')">Teachers</button>
    <button onclick="navigateTo('grades')">Grades</button>
`;
