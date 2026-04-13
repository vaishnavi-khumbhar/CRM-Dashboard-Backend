package com.crm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crm.project.entity.User;
import com.crm.project.repository.UserRepository;
import com.crm.project.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserService userService;

    // ✅ SIGNUP
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        // Trim values
        String email = user.getEmail().trim();
        String password = user.getPassword().trim();

        // 🔥 CHECK IF USER ALREADY EXISTS
        User existing = repo.findByEmailIgnoreCase(email);
        if (existing != null) {
            return "User already exists";
        }

        user.setEmail(email);
        user.setPassword(password);

        repo.save(user);

        return "Signup Successful";
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        String email = user.getEmail().trim();
        String password = user.getPassword().trim();

        // 🔥 CASE-INSENSITIVE EMAIL SEARCH
        User existing = repo.findByEmailIgnoreCase(email);

        if (existing != null && existing.getPassword().equals(password)) {

            // 🔥 SAVE LOGIN HISTORY
            userService.saveLoginHistory("LOGIN", email);

            return "Login Successful";
        } else {
            return "Invalid Credentials";
        }
    }

    // ✅ LOGOUT
    @PostMapping("/logout")
    public String logout(@RequestParam String email) {

        if (email == null || email.isEmpty()) {
            return "Email required";
        }

        // 🔥 SAVE LOGOUT HISTORY
        userService.saveLoginHistory("LOGOUT", email.trim());

        return "Logout Successful";
    }
}