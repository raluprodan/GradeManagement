function loadGrades() {
    checkAuth();
    authFetch("/api/grades")
        .then(res => res.json())
        .then(data => {
            renderGrades(data);
        });
}

function renderGrades(grades) {
    const table = document.getElementById("gradesTable");
    table.innerHTML = "<tr><th>Student</th><th>Course</th><th>Grade</th><th>Action</th></tr>";
    grades.forEach(g => {
        const row = document.createElement("tr");
        row.innerHTML = `
      <td>${g.studentName}</td>
      <td>${g.courseName}</td>
      <td><input type="text" value="${g.grade}" id="grade-${g.id}"/></td>
      <td><button onclick="updateGrade(${g.id})">Save</button></td>
    `;
        table.appendChild(row);
    });
}

function updateGrade(id) {
    const newGrade = document.getElementById(`grade-${id}`).value;
    authFetch(`/api/grades/${id}`, {
        method: 'PUT',
        body: JSON.stringify({ grade: newGrade })
    }).then(res => {
        if (res.ok) alert("Updated!");
        else alert("Failed!");
    });
}
