// let teachers = [];
//
// function loadTeachers() {
//     checkAuth();
//     authFetch("/api/professors")
//         .then(res => res.json())
//         .then(data => {
//             teachers = data;
//             renderTeachers(data);
//         });
// }
//
// function renderTeachers(list) {
//     const ul = document.getElementById("teacherList");
//     ul.innerHTML = "";
//     list.forEach(t => {
//         const li = document.createElement("li");
//         li.innerText = t.name + " - " + t.id;
//         ul.appendChild(li);
//     });
// }
//
// function filterTeachers() {
//     const q = document.getElementById("teacherFilter").value.toLowerCase();
//     const filtered = teachers.filter(t => t.name.toLowerCase().includes(q));
//     renderTeachers(filtered);
// }
