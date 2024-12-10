package com.klu.studentlearningtracer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.klu.studentlearningtracer.service.StudentService;

@Controller
public class WebController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }
}
