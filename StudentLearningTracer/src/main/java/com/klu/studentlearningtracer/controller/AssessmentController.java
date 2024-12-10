package com.klu.studentlearningtracer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssessmentController {

    @GetMapping("/submit-assessment")
    public String showSubmitAssessmentForm() {
        return "submit-assessment"; // This will render the submit-assessment.html Thymeleaf template
    }

    @PostMapping("/submit-assessment")
    public String submitAssessment(@RequestParam String assessmentName, 
                                   @RequestParam int score, 
                                   @RequestParam String status) {
        // Handle the form submission, e.g., save the data to the database
        System.out.println("Assessment Name: " + assessmentName);
        System.out.println("Score: " + score);
        System.out.println("Status: " + status);
        return "redirect:/"; // Redirect after successful submission
    }
}
