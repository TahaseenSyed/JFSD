document.addEventListener("DOMContentLoaded", function() {
    // Example data for academic progress and performance metrics
    const academicProgress = "85%";
    const performanceMetrics = "Excellent";

    // Example assessment data
    const assessments = [
        { name: "Math Test", score: "95%", status: "Completed" },
        { name: "Science Project", score: "89%", status: "In Progress" },
        { name: "History Essay", score: "92%", status: "Completed" }
    ];

    // Update the dashboard
    document.getElementById('academic-progress').innerText = academicProgress;
    document.getElementById('performance-metrics').innerText = performanceMetrics;

    // Function to render the assessments table
    function renderAssessments() {
        const assessmentTableBody = document.getElementById('assessment-data');
        assessmentTableBody.innerHTML = ''; // Clear existing rows
        assessments.forEach((assessment, index) => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${assessment.name}</td>
                <td>${assessment.score}</td>
                <td>${assessment.status}</td>
                <td>
                    <button class="action-button" onclick="editAssessment(${index})">Edit</button>
                    <button class="action-button" onclick="deleteAssessment(${index})">Delete</button>
                </td>
            `;
            assessmentTableBody.appendChild(row);
        });
    }

    // Initial render of the assessments table
    renderAssessments();

    // Function to handle creating a new assessment
    document.getElementById('create-assessment-form').addEventListener('submit', function(event) {
        event.preventDefault();
        const name = document.getElementById('assessment-name').value;
        const score = document.getElementById('assessment-score').value;
        const status = document.getElementById('assessment-status').value;
        
        // Add the new assessment to the array
        assessments.push({ name, score, status });
        renderAssessments(); // Re-render the table
    });

    // Function to handle editing an assessment
    window.editAssessment = function(index) {
        const assessment = assessments[index];
        const name = prompt("Edit Assessment Name:", assessment.name);
        const score = prompt("Edit Score:", assessment.score);
        const status = prompt("Edit Status:", assessment.status);

        if (name && score && status) {
            assessments[index] = { name, score, status }; // Update the assessment
            renderAssessments(); // Re-render the table
        }
    };

    // Function to handle deleting an assessment
    window.deleteAssessment = function(index) {
        if (confirm("Are you sure you want to delete this assessment?")) {
            assessments.splice(index, 1); // Remove the assessment
            renderAssessments(); // Re-render the table
        }
    };
});
