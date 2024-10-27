let students = JSON.parse(localStorage.getItem("students")) || [];

function saveStudents() {
  localStorage.setItem("students", JSON.stringify(students));
}

function addStudent(event) {
  event.preventDefault(); 
  const name = document.getElementById("addStudentName").value;
  const id = document.getElementById("addStudentId").value;
  const email = document.getElementById("addStudentEmail").value;
  const phone = document.getElementById("addStudentPhone").value;

  const student = { id, name, email, phone };
  students.push(student); 
  saveStudents(); 
  alert("Student added successfully!"); 

  document.getElementById("addStudentForm").reset();
}

function renderStudentTable() {
  const tableBody = document.querySelector("#studentList tbody");
  tableBody.innerHTML = ""; 

  if (students.length === 0) {
    const row = document.createElement("tr");
    row.innerHTML = `<td colspan="5" class="text-center">No students available</td>`;
    tableBody.appendChild(row);
  } else {
    students.forEach((student) => {
      const row = document.createElement("tr");
      row.innerHTML = `
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.phone}</td>
                <td>
                    <button class="btn btn-danger btn-sm" onclick="deleteStudent('${student.id}')">Delete</button>
                </td>
            `;
      tableBody.appendChild(row);
    });
  }
}

function deleteStudent(studentId) {
  students = students.filter((student) => student.id !== studentId); 
  saveStudents(); 
  renderStudentTable();
}

if (window.location.pathname.includes("admin.html")) {
  document
    .getElementById("addStudentForm")
    .addEventListener("submit", addStudent);
}

if (window.location.pathname.includes("admin-student.html")) {
  renderStudentTable(); 
}
