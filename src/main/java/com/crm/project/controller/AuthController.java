package com.crm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crm.project.entity.User;
import com.crm.project.repository.UserRepository;
import com.crm.project.service.UserService;

@RestController
@RequestMapping("/api/auth")

// ✅ CORS FIX (Frontend allow)
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://vaishnavi-khumbhar.github.io"
})
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserService userService;

    // ✅ SIGNUP
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        if (user.getEmail() == null || user.getPassword() == null) {
            return "Invalid Data";
        }

        String email = user.getEmail().trim().toLowerCase();
        String password = user.getPassword().trim();

        // check existing user
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

        if (user.getEmail() == null || user.getPassword() == null) {
            return "Invalid Credentials";
        }

        String email = user.getEmail().trim().toLowerCase();
        String password = user.getPassword().trim();

        User existing = repo.findByEmailIgnoreCase(email);

        if (existing != null && existing.getPassword().equals(password)) {

            userService.saveLoginHistory("LOGIN", email);

            return "Login Successful";
        }

        return "Invalid Credentials";
    }

    // ✅ LOGOUT
    @PostMapping("/logout")
    public String logout(@RequestParam String email) {

        if (email == null || email.isEmpty()) {
            return "Email required";
        }

        userService.saveLoginHistory("LOGOUT", email.trim().toLowerCase());

        return "Logout Successful";
    }
}
