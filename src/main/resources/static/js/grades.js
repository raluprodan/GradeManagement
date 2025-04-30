const students = [
    { registryNumber: "REG2024001", last_name: "Lazar", first_name: "Alexia", year: 1, userId: 1, activeYear: true },
    { registryNumber: "REG2024002", last_name: "Harlea", first_name: "Ana", year: 2, userId: 2, activeYear: true },
    { registryNumber: "REG2024003", last_name: "Prodan", first_name: "Raluca", year: 1, userId: 52, activeYear: false },
    { registryNumber: "REG2024004", last_name: "Radu", first_name: "Stoica", year: 3, userId: 102, activeYear: true },
    { registryNumber: "REG2024005", last_name: "Dumitrescu", first_name: "Vlad", year: 2, userId: 103, activeYear: true },
    { registryNumber: "REG2024006", last_name: "Popescu", first_name: "Andrei", year: 1, userId: 104, activeYear: false },
    { registryNumber: "REG2024007", last_name: "Radu", first_name: "Elena", year: 3, userId: 105, activeYear: true },
    { registryNumber: "REG2024008", last_name: "Dobre", first_name: "Ioana", year: 2, userId: 106, activeYear: true },
    { registryNumber: "REG2024009", last_name: "Neagu", first_name: "Olivia", year: 3, userId: 107, activeYear: false },
    { registryNumber: "REG2024010", last_name: "Ciobanu", first_name: "Alexandra", year: 1, userId: 108, activeYear: true },
];

const mockGrades = {
    1: { "Math": 8, "Biology": 9 },
    2: { "Math": 10, "Physics": 7 },
    52: { "Biology": 5 },
    102: { "Computer Science": 9 },
    103: { "Math": 6, "Biology": 8 },
    104: { "Physics": 4 },
    105: { "Computer Science": 9 },
    106: { "Math": 7, "Physics": 8 },
    107: { "Biology": 6 },
    108: { "Math": 9, "Computer Science": 10 }
};

function loadGrades() {
    filterGrades(); // default load with no filters
}

function filterGrades() {
    const lastName = document.getElementById("lastNameFilter").value.toLowerCase();
    const firstName = document.getElementById("firstNameFilter").value.toLowerCase();
    const year = document.getElementById("yearFilter").value;

    let filtered = students.filter(s => {
        return (!lastName || s.last_name.toLowerCase().includes(lastName)) &&
            (!firstName || s.first_name.toLowerCase().includes(firstName)) &&
            (!year || s.year == parseInt(year));
    });


    const tbody = document.getElementById("gradesTableBody");
    tbody.innerHTML = "";

    filtered.forEach(student => {
        const tr = document.createElement("tr");
        const fullName = `${student.first_name} ${student.last_name}`;
        const grades = mockGrades[student.userId] || {};
        const gradeList = Object.entries(grades).map(([subject, grade]) => `${subject}: ${grade}`).join(", ");

        tr.innerHTML = `
            <td>${fullName}</td>
            <td>${student.year}</td>
            <td>${gradeList || "No grades yet"}</td>
        `;

        tbody.appendChild(tr);
    });
}
