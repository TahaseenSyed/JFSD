

function deleteAssessment(id) {
    if (confirm("Are you sure you want to delete this assessment?")) {
        fetch(`/admin/delete?id=${id}`, {
            method: "DELETE",
        })
        .then(response => {
            if (response.ok) {
                alert("Assessment deleted successfully!");
                // Reload the page to reflect changes
                window.location.reload();
            } else {
                alert("Error deleting assessment.");
            }
        })
        .catch(error => console.error("Error:", error));
    }
}
