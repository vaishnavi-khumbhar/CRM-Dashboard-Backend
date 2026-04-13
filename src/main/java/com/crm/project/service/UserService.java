package com.crm.project.service;

import com.crm.project.entity.User;
import com.crm.project.entity.LoginHistory;
import com.crm.project.repository.UserRepository;
import com.crm.project.repository.LoginHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginHistoryRepository historyRepository;

    // ✅ Get Profile
    public User getProfile() {
        return userRepository.findAll().stream().findFirst().orElse(null);
    }

    // ✅ Update User
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // ✅ Get History
    public List<LoginHistory> getHistory() {
        return historyRepository.findAll();
    }

    // ✅ 🔥 ADD THIS (SAVE LOGIN HISTORY)
    public void saveLoginHistory(String action, String email) {
        LoginHistory history = new LoginHistory();

        history.setEmail(action + " - " + email);  // LOGIN - email
        history.setTime(LocalDateTime.now().toString());

        historyRepository.save(history);
    }

    // ✅ Delete single history
    public void deleteHistory(Long id) {
        historyRepository.deleteById(id);
    }

    // ✅ Delete all history
    public void deleteAllHistory() {
        historyRepository.deleteAll();
    }
}