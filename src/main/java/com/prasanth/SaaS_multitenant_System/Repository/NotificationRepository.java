package com.prasanth.SaaS_multitenant_System.Repository;

import com.prasanth.SaaS_multitenant_System.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
