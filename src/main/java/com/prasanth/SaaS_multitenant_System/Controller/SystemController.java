package com.prasanth.SaaS_multitenant_System.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system")
public class SystemController {
    @GetMapping("/health")
    public String health(){
        return "Application running";
    }
}
