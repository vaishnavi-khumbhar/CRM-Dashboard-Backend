package com.crm.project.controller;

import com.crm.project.entity.User;
import com.crm.project.entity.LoginHistory;
import com.crm.project.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserSettingController {

    @Autowired
    private UserService userService;

    // ✅ Get Profile
    @GetMapping("/profile")
    public User getProfile() {
        return userService.getProfile();
    }

    // ✅ Update Profile
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // ✅ Get Login History
    @GetMapping("/history")
    public List<LoginHistory> getHistory() {
        return userService.getHistory();
    }

    // ✅ Delete single
    @DeleteMapping("/history/{id}")
    public void deleteHistory(@PathVariable Long id) {
        userService.deleteHistory(id);
    }

    // ✅ Delete all
    @DeleteMapping("/history")
    public void deleteAllHistory() {
        userService.deleteAllHistory();
    }

    // ✅ 🔥 TEST API (IMPORTANT)
    @PostMapping("/test-history")
    public String testHistory() {
    	userService.saveLoginHistory("TEST", "admin@gmail.com");        return "History Added!";
    }
}