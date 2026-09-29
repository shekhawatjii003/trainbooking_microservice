package com.example.notification_service.controller;

import com.example.notification_service.entity.Notification;
import com.example.notification_service.entity.NotificationStatus;
import com.example.notification_service.entity.NotificationType;
import com.example.notification_service.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {

        this.notificationService =
                notificationService;
    }

    @PostMapping
    public Notification createNotification(
            @RequestBody Notification notification) {

        return notificationService
                .createNotification(notification);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {

        return notificationService
                .getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(
            @PathVariable Long id) {

        return notificationService
                .getNotificationById(id);
    }

    @PutMapping("/{id}")
    public Notification updateNotification(
            @PathVariable Long id,
            @RequestBody Notification notification) {

        return notificationService
                .updateNotification(id, notification);
    }

    @DeleteMapping("/{id}")
    public Notification deleteNotification(
            @PathVariable Long id) {

        return notificationService
                .deleteNotification(id);
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsByUser(
            @PathVariable Long userId) {

        return notificationService
                .getNotificationsByUser(userId);
    }

    @GetMapping("/booking/{bookingId}")
    public List<Notification> getNotificationsByBooking(
            @PathVariable Long bookingId) {

        return notificationService
                .getNotificationsByBooking(bookingId);
    }

    @GetMapping("/ticket/{ticketId}")
    public List<Notification> getNotificationsByTicket(
            @PathVariable Long ticketId) {

        return notificationService
                .getNotificationsByTicket(ticketId);
    }

    @GetMapping("/status/{status}")
    public List<Notification> getNotificationsByStatus(
            @PathVariable NotificationStatus status) {

        return notificationService
                .getNotificationsByStatus(status);
    }

    @GetMapping("/type/{type}")
    public List<Notification> getNotificationsByType(
            @PathVariable NotificationType type) {

        return notificationService
                .getNotificationsByType(type);
    }

    @GetMapping("/user/{userId}/recent")
    public List<Notification> getRecentNotifications(
            @PathVariable Long userId) {

        return notificationService
                .getRecentNotificationsByUser(userId);
    }

    @PutMapping("/{id}/send")
    public Notification sendNotification(
            @PathVariable Long id) {

        return notificationService
                .sendNotification(id);
    }
}