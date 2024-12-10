package com.klu.studentlearningtracer.controller;

import com.klu.studentlearningtracer.model.User;
import com.klu.studentlearningtracer.service.UserService;
import com.klu.studentlearningtracer.model.Assessment;
import com.klu.studentlearningtracer.service.AssessmentService;
import com.klu.studentlearningtracer.service.StudentService; // Import the StudentService

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private StudentService studentService; // Autowire the StudentService

    // Admin login page
    @GetMapping("/admin-login")
    public String adminLoginPage() {
        return "admin-login"; // Name of the login HTML or JSP page
    }

    // Admin login validation
    @PostMapping("/admin-login")
    public String adminLogin(@RequestParam String username, @RequestParam String password) {
        User user = userService.validateUser(username, password);
        if (user != null && "admin".equals(user.getRole())) {
            return "redirect:/admin/dashboard"; // Correct URL for redirecting to the dashboard
        } else {
            return "redirect:/admin-login?error=true"; // Redirect back with error if invalid login
        }
    }

    // Admin dashboard page
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin-dashboard"; // Name of the admin dashboard page (ensure this file exists in templates)
    }

    // Save assessment data
    @PostMapping("/save")
    public String saveAssessment(@ModelAttribute Assessment assessment) {
        // Save the assessment logic
        assessmentService.saveAssessment(assessment);
        return "redirect:/admin/dashboard"; // Redirect to the dashboard or another page
    }

    // Manage students page
    @GetMapping("/manage-students")
    public String manageStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());  // Add all students to the model
        return "manage-students";  // The view will be resolved to manage-students.html
    }
}
