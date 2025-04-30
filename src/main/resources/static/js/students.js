let students = [];

function loadStudents() {
    checkAuth();
    authFetch("/api/students")
        .then(res => res.json())
        .then(data => {
            students = data;
            renderStudentList(data);
        });
}

function renderStudentList(list) {
    const ul = document.getElementById("studentList");
    ul.innerHTML = "";
    list.forEach(s => {
        const li = document.createElement("li");
        li.innerText = s.name + " - " + s.id;
        ul.appendChild(li);
    });
}

function filterStudents() {
    const query = document.getElementById("search").value.toLowerCase();
    const filtered = students.filter(s => s.name.toLowerCase().includes(query));
    renderStudentList(filtered);
}
