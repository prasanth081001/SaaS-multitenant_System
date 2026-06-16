package com.prasanth.SaaS_multitenant_System.Controller;

import com.prasanth.SaaS_multitenant_System.Model.Project;
import com.prasanth.SaaS_multitenant_System.Service.ProjectService;
import com.prasanth.SaaS_multitenant_System.dto.ProjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService service;

    @PostMapping
    public Project createProject(
            @RequestBody ProjectRequest request){

        return service.createProject(
                request);
    }

    @GetMapping
    public List<Project> getProjects(){

        return service.getProjects();
    }

    @GetMapping("/{id}")
    public Project getProject(
            @PathVariable Long id){

        return service.getProject(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable Long id,
            @RequestBody ProjectRequest request){

        return service.updateProject(
                id,
                request);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(
            @PathVariable Long id){

        service.deleteProject(id);

        return "Project Deleted";
    }

    @GetMapping("/high-risk")
    public List<Project> highRiskProjects(){

        return service.getHighRiskProjects();
    }
}
