package com.prasanth.SaaS_multitenant_System.Controller;

import com.prasanth.SaaS_multitenant_System.Model.Notification;
import com.prasanth.SaaS_multitenant_System.Service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService service;

    @PostMapping
    public Notification createNotification(
            @RequestBody Notification notification){

        return service.save(notification);
    }

    @GetMapping
    public List<Notification> getAllNotifications(){

        return service.getAll();
    }

    @PutMapping("/{id}/read")
    public String markAsRead(
            @PathVariable Long id){

        service.markAsRead(id);

        return "Notification marked as read";
    }
}
