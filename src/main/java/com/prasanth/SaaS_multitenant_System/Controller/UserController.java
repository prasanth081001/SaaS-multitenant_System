package com.prasanth.SaaS_multitenant_System.Controller;

import com.prasanth.SaaS_multitenant_System.Model.User;
import com.prasanth.SaaS_multitenant_System.Service.UserService;
import com.prasanth.SaaS_multitenant_System.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public User createUser(
            @RequestBody UserRequest request){

        return service.createUser(request);
    }

    @GetMapping
    public List<User> getUsers(){

        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(
            @PathVariable Long id){

        return service.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody UserRequest request){

        return service.updateUser(
                id,
                request);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(
            @PathVariable Long id){

        service.deleteUser(id);

        return "User Deleted";
    }
}
