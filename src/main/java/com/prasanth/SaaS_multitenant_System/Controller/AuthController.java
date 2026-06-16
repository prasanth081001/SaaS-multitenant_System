package com.prasanth.SaaS_multitenant_System.Controller;

import com.prasanth.SaaS_multitenant_System.Service.AuthService;
import com.prasanth.SaaS_multitenant_System.Service.UserService;
import com.prasanth.SaaS_multitenant_System.dto.LoginRequest;
import com.prasanth.SaaS_multitenant_System.dto.LoginResponse;
import com.prasanth.SaaS_multitenant_System.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request){

        String token =
                authService.login(request);

        return new LoginResponse(token);
    }

    @PostMapping("/register")
    public Object register(
            @RequestBody UserRequest request){

        return userService.createUser(
                request);
    }
}
