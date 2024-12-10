package com.klu.studentlearningtracer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    // Show the registration form
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";  // Returns the registration page
    }

    // Handle the registration logic
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password,
                           @RequestParam String confirmPassword, @RequestParam String role, Model model) {
        
        // Basic validation for matching passwords
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match. Please try again.");
            return "register";  // Returns the registration page with an error message
        }

        // Simple logic to "register" based on role, username, and password
        if (role.equals("admin") && username.equals("admin123") && password.equals("adminPass")) {
            // Simulate successful admin registration (in real-world, store data in DB)
            model.addAttribute("message", "Admin registered successfully!");
            return "redirect:/login";  // Redirect to login page after registration
        } else if (role.equals("student") && username.equals("student123") && password.equals("studentPass")) {
            // Simulate successful student registration (in real-world, store data in DB)
            model.addAttribute("message", "Student registered successfully!");
            return "redirect:/login";  // Redirect to login page after registration
        } else {
            model.addAttribute("error", "Registration failed. Please check the details.");
            return "register";  // Return to registration page with an error message
        }
    }
}
