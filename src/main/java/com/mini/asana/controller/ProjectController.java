package com.mini.asana.controller;

import com.mini.asana.dto.ProjectDto;
import com.mini.asana.dto.TaskDto;
import com.mini.asana.service.ProjectService;
import com.mini.asana.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }


    @PostMapping("/projects")
    public ResponseEntity<Boolean> saveProject(@RequestBody ProjectDto dto){
        return ResponseEntity.ok().body(projectService.saveProject(dto));
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable long id){
        return ResponseEntity.ok().body(projectService.deleteProject(id));
    }
}
