package com.crm.project.controller;

import com.crm.project.entity.Notification;
import com.crm.project.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin("*") // React connect साठी
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // ✅ Create Notification (Testing साठी)
    @PostMapping
    public Notification createNotification(@RequestParam String message,
                                           @RequestParam String type) {
        return notificationService.createNotification(message, type);
    }

    // ✅ Get All Notifications
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    // ✅ Get Unread Notifications
    @GetMapping("/unread")
    public List<Notification> getUnreadNotifications() {
        return notificationService.getUnreadNotifications();
    }

    // ✅ Mark as Read
    @PutMapping("/{id}")
    public Notification markAsRead(@PathVariable Long id) {
        return notificationService.markAsRead(id);
    }
}