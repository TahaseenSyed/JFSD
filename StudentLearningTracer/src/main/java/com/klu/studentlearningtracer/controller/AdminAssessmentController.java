package com.klu.studentlearningtracer.controller;

import com.klu.studentlearningtracer.model.Assessment;
import com.klu.studentlearningtracer.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminAssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping("/manage-assessments")
    public String showAssessments(Model model) {
        model.addAttribute("assessments", assessmentService.getAllAssessments());
        return "manage-assessments"; // Manage assessments page
    }

    @GetMapping("/edit/{id}")
    public String editAssessment(@PathVariable("id") Long id, Model model) {
        // Get assessment by ID, and check if it exists
        Assessment assessment = assessmentService.getAssessmentById(id)
            .orElseThrow(() -> new RuntimeException("Assessment not found with ID: " + id));
        model.addAttribute("assessment", assessment);
        return "edit-assessment"; // Edit assessment page
    }

    @PostMapping("/update")
    public String updateAssessment(@ModelAttribute Assessment assessment) {
        assessmentService.saveAssessment(assessment);
        return "redirect:/admin/manage-assessments";
    }

    @GetMapping("/delete/{id}")
    public String deleteAssessment(@PathVariable("id") Long id) {
        assessmentService.deleteAssessment(id);
        return "redirect:/admin/manage-assessments";
    }
}
