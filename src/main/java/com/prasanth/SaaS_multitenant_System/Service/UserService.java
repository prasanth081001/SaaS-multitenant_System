package com.prasanth.SaaS_multitenant_System.Service;

import com.prasanth.SaaS_multitenant_System.Model.Tenant;
import com.prasanth.SaaS_multitenant_System.Model.User;
import com.prasanth.SaaS_multitenant_System.Repository.TenantRepository;
import com.prasanth.SaaS_multitenant_System.Repository.UserRepository;
import com.prasanth.SaaS_multitenant_System.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final TenantRepository tenantRepository;

    private final PasswordEncoder passwordEncoder;

    public User createUser(
            UserRequest request){

        Tenant tenant =
                tenantRepository.findById(
                                request.getTenantId())
                        .orElseThrow();

        User user =
                User.builder()
                        .username(
                                request.getUsername())
                        .password(
                                passwordEncoder.encode(
                                        request.getPassword()))
                        .role(
                                request.getRole())
                        .tenant(tenant)
                        .build();

        return userRepository.save(user);
    }

    public List<User> getUsers(){

        return userRepository.findAll();
    }

    public User getUser(Long id){

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User Not Found"));
    }

    public User updateUser(
            Long id,
            UserRequest request){

        User user = getUser(id);

        user.setUsername(
                request.getUsername());

        user.setRole(
                request.getRole());

        return userRepository.save(user);
    }

    public void deleteUser(Long id){

        userRepository.deleteById(id);
    }
}
