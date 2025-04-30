// let students = [];
//
// function loadStudents() {
//     checkAuth();
//     authFetch("/api/students")
//         .then(res => res.json())
//         .then(data => {
//             students = data;
//             renderStudentTable(data);
//         });
// }
//
// function renderStudentTable(list) {
//     const table = document.getElementById("studentTableBody");
//     table.innerHTML = "";
//
//     list.forEach(s => {
//         const tr = document.createElement("tr");
//         tr.innerHTML = `
//             <td>${s.id}</td>
//             <td>${s.name || ''}</td>
//             <td>${s.registryNumber || ''}</td>
//             <td>${s.year || ''}</td>
//             <td>${s.activeYear ? "Yes" : "No"}</td>
//         `;
//         table.appendChild(tr);
//     });
// }
//
// function filterStudents() {
//     const criteria = document.getElementById("filterCriteria").value;
//     const query = document.getElementById("searchInput").value.toLowerCase();
//
//     if (criteria === "all" || query === "") {
//         renderStudentTable(students);
//         return;
//     }
//
//     const filtered = students.filter(s => {
//         const value = (s[criteria] || "").toString().toLowerCase();
//         return value.includes(query);
//     });
//
//     renderStudentTable(filtered);
// }
const students = [
    { registryNumber: "REG2024001",last_name: "Lazar",first_name: "Alexia", year: 1, userId: 1, activeYear: true },
    { registryNumber: "REG2024002",last_name: "Harlea",first_name: "Ana", year: 2, userId: 2, activeYear: true },
    { registryNumber: "REG2024003",last_name: "Prodan",first_name: "Raluca", year: 1, userId: 52, activeYear: false },
    { registryNumber: "REG2024004",last_name: "Radu",first_name: "Stoica", year: 3, userId: 102, activeYear: true },
    { registryNumber: "REG2024005",last_name: "Dumitrescu",first_name: "Vlad", year: 2, userId: 103, activeYear: true },
    { registryNumber: "REG2024006",last_name: "Popescu",first_name: "Andrei", year: 1, userId: 104, activeYear: false },
    { registryNumber: "REG2024007",last_name: "Radu",first_name: "Elena", year: 3, userId: 105, activeYear: true },
    { registryNumber: "REG2024008",last_name: "Dobre",first_name: "Ioana", year: 2, userId: 106, activeYear: true },
    { registryNumber: "REG2024009",last_name: "Neagu",first_name: "Olivia", year: 3, userId: 107, activeYear: false },
    { registryNumber: "REG2024010",last_name: "Ciobanu",first_name: "Alexandra", year: 1, userId: 108, activeYear: true },
];

function loadStudents() {
    renderStudentTable(students);
}

function renderStudentTable(list) {
    const tbody = document.getElementById("studentTableBody");
    tbody.innerHTML = "";
    list.forEach(s => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${s.registryNumber}</td>
            <td>${s.last_name}</td>
            <td>${s.first_name}</td>
            <td>${s.year}</td>
            <td>${s.userId}</td>
            <td>${s.activeYear ? "Yes" : "No"}</td>
        `;
        tbody.appendChild(tr);
    });
}

function filterStudents() {
    const reg = document.getElementById("registryFilter").value.toLowerCase();
    const year = document.getElementById("yearFilter").value;
    const active = document.getElementById("activeFilter").value;
    const lastName = document.getElementById("lastNameFilter").value.toLowerCase();
    const firstName = document.getElementById("firstNameFilter").value.toLowerCase();


    const filtered = students.filter(s => {
        const matchesReg = reg === "" || s.registryNumber.toLowerCase().includes(reg);
        const matchesYear = year === "" || s.year === parseInt(year);
        const matchesActive = active === "" || s.activeYear === (active === "true");
        const matchesFirst = firstName === "" || s.first_name.toLowerCase().includes(firstName);
        const matchesLast = lastName === "" || s.last_name.toLowerCase().includes(lastName);


        return matchesReg && matchesYear && matchesActive && matchesFirst && matchesLast;
    });

    renderStudentTable(filtered);
}
