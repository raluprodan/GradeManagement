const role = localStorage.getItem("role");
const isProfessor = role === "professor";

const students = [
    { registryNumber: "REG2024001", last_name: "Lazar", first_name: "Alexia", year: 1, userId: 1 },
    { registryNumber: "REG2024002", last_name: "Harlea", first_name: "Ana", year: 2, userId: 2 },
    { registryNumber: "REG2024003", last_name: "Prodan", first_name: "Raluca", year: 1, userId: 52 },
    { registryNumber: "REG2024004", last_name: "Radu", first_name: "Stoica", year: 3, userId: 102 },
    { registryNumber: "REG2024005", last_name: "Dumitrescu", first_name: "Vlad", year: 2, userId: 103 },
    { registryNumber: "REG2024006", last_name: "Popescu", first_name: "Andrei", year: 1, userId: 104 },
    { registryNumber: "REG2024007", last_name: "Radu", first_name: "Elena", year: 3, userId: 105 },
    { registryNumber: "REG2024008", last_name: "Dobre", first_name: "Ioana", year: 2, userId: 106 },
    { registryNumber: "REG2024009", last_name: "Neagu", first_name: "Olivia", year: 3, userId: 107 },
    { registryNumber: "REG2024010", last_name: "Ciobanu", first_name: "Alexandra", year: 1, userId: 108 },
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
    filterGrades();
}

function filterGrades() {
    const lastName = document.getElementById("lastNameFilter").value.toLowerCase();
    const firstName = document.getElementById("firstNameFilter").value.toLowerCase();
    const year = document.getElementById("yearFilter").value;

    const tbody = document.getElementById("gradesTableBody");
    tbody.innerHTML = "";

    const filtered = students.filter(s =>
        (!lastName || s.last_name.toLowerCase().includes(lastName)) &&
        (!firstName || s.first_name.toLowerCase().includes(firstName)) &&
        (!year || s.year == parseInt(year))
    );

    filtered.forEach(student => {
        const tr = document.createElement("tr");
        const fullName = `${student.first_name} ${student.last_name}`;
        const grades = mockGrades[student.userId] || {};

        let gradesHTML = "";

        if (isProfessor) {
            // Editable inputs for each subject
            gradesHTML = Object.entries(grades).map(([subject, grade]) => `
                <div>
                    <label>${subject}:</label>
                    <input type="number" min="1" max="10" value="${grade}" 
                        data-subject="${subject}" data-user="${student.userId}">
                </div>
            `).join("");

            // Add button to save changes
            gradesHTML += `
                <button onclick="saveGrades(${student.userId})">Save</button>
            `;
        } else {
            // Display only
            gradesHTML = Object.entries(grades).map(([subject, grade]) => `${subject}: ${grade}`).join(", ") || "No grades yet";
        }

        tr.innerHTML = `
            <td>${fullName}</td>
            <td>${student.year}</td>
            <td>${gradesHTML}</td>
        `;
        tbody.appendChild(tr);
    });
}

function saveGrades(userId) {
    const inputs = document.querySelectorAll(`input[data-user="${userId}"]`);
    const updatedGrades = {};
    inputs.forEach(input => {
        const subject = input.getAttribute("data-subject");
        const grade = parseInt(input.value);
        if (!isNaN(grade)) {
            updatedGrades[subject] = grade;
        }
    });
    mockGrades[userId] = updatedGrades;
    alert("Grades saved!");
    filterGrades(); // refresh the table
}
