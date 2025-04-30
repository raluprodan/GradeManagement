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
const professors = [
    { is_form_master: true, subject: "Mathematics", id: 53, firstName: "John", lastName: "Doe" },
    { is_form_master: false, subject: "Biology", id: 54, firstName: "Maria", lastName: "Harlea" },
    { is_form_master: false, subject: "Physics", id: 109, firstName: "Andreea", lastName: "Molnar" },
    { is_form_master: true, subject: "Computer Science", id: 110, firstName: "Teodor", lastName: "Mita" },
];

function loadProfessors() {
    renderProfessorTable(professors);
}

function renderProfessorTable(list) {
    const tbody = document.getElementById("professorTableBody");
    tbody.innerHTML = "";
    list.forEach(p => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${p.is_form_master ? "Yes" : "No"}</td>
            <td>${p.subject}</td>
            <td>${p.id}</td>
            <td>${p.firstName}</td>
            <td>${p.lastName}</td>
        `;
        tbody.appendChild(tr);
    });
}

function filterProfessors() {
    const subject = document.getElementById("subjectFilter").value.toLowerCase();
    const firstName = document.getElementById("firstNameFilter").value.toLowerCase();
    const lastName = document.getElementById("lastNameFilter").value.toLowerCase();
    const formMaster = document.getElementById("formMasterFilter").value;

    const filtered = professors.filter(p => {
        const matchesSubject = subject === "" || p.subject.toLowerCase().includes(subject);
        const matchesFirst = firstName === "" || p.firstName.toLowerCase().includes(firstName);
        const matchesLast = lastName === "" || p.lastName.toLowerCase().includes(lastName);
        const matchesFormMaster = formMaster === "" || p.is_form_master === (formMaster === "true");
        return matchesSubject && matchesFirst && matchesLast && matchesFormMaster;
    });

    renderProfessorTable(filtered);
}
