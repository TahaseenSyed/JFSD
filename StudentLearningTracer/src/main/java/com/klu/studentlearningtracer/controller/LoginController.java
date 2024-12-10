package com.klu.studentlearningtracer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String role, Model model) {
        if (role.equals("admin") && username.equals("admin123") && password.equals("adminPass")) {
            return "redirect:/admin-dashboard";  // Redirect to admin dashboard after login
        } else if (role.equals("student") && username.equals("student123") && password.equals("studentPass")) {
            return "redirect:/student-dashboard";  // Redirect to student dashboard after login
        } else {
            model.addAttribute("error", "Invalid username, password, or role.");
            return "login";  // Return to login page with an error message
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";  // Redirect to login page after logout
    }
}
