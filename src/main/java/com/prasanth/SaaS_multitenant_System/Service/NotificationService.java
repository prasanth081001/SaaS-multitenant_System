package com.prasanth.SaaS_multitenant_System.Service;

import com.prasanth.SaaS_multitenant_System.Model.Notification;
import com.prasanth.SaaS_multitenant_System.Model.Tenant;
import com.prasanth.SaaS_multitenant_System.Repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository repository;

    public Notification createNotification(
            Tenant tenant,
            String message){

        Notification notification =
                Notification.builder()
                        .message(message)
                        .readStatus(false)
                        .tenant(tenant)
                        .build();

        return repository.save(
                notification);
    }
    public Notification save(
            Notification notification){

        return repository.save(notification);
    }

    public void markAsRead(Long id){

        Notification notification =
                repository.findById(id)
                        .orElseThrow();

        notification.setReadStatus(true);

        repository.save(notification);
    }

    public List<Notification> getAll(){

        return repository.findAll();
    }
}
