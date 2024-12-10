package com.klu.studentlearningtracer.controller;

import com.klu.studentlearningtracer.model.Student;
import com.klu.studentlearningtracer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/admin")
public class AdminStudentController {

    @Autowired
    private StudentService studentService;

    // Endpoint to view student details by ID
    @GetMapping("/view-student-details/{id}")
    public String viewStudentDetails(@PathVariable("id") Long id, Model model) {
        // Fetch student by ID from the service
        Student student = studentService.getStudentById(id);
        
        // If student not found, redirect to the manage students page
        if (student == null) {
            return "redirect:/admin/manage-students"; // Or return a 404 page
        }

        model.addAttribute("student", student); // Add student object to model for the view
        return "view-student-details"; // Return the page where the student details will be displayed
    }
}
