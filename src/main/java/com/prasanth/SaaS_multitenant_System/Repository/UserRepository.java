package com.prasanth.SaaS_multitenant_System.Repository;

import com.prasanth.SaaS_multitenant_System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
