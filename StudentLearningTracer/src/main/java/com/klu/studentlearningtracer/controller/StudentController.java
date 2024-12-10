package com.klu.studentlearningtracer.controller;

import com.klu.studentlearningtracer.model.User;
import com.klu.studentlearningtracer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private UserService userService;

    @GetMapping("/student-login")
    public String studentLoginPage() {
        return "student-login"; // Name of the login HTML or JSP page
    }

    @PostMapping("/student-login")
    public String studentLogin(@RequestParam String username, @RequestParam String password) {
        User user = userService.validateUser(username, password);
        if (user != null && "student".equals(user.getRole())) {
            return "redirect:/student-dashboard"; // Redirect to dashboard if student credentials are correct
        } else {
            return "redirect:/student-login?error=true"; // Redirect back with error if invalid login
        }
    }

    @GetMapping("/student-dashboard")
    public String studentDashboard() {
        return "student-dashboard"; // Name of the student dashboard page
    }
}