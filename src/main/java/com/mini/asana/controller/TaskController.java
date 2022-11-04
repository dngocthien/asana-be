package com.mini.asana.controller;

import com.mini.asana.dto.TaskDto;
import com.mini.asana.entity.Task;
import com.mini.asana.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @PostMapping("/tasks")
    public ResponseEntity<Boolean> saveTask(@RequestBody TaskDto dto){
        return ResponseEntity.ok().body(taskService.saveTask(dto));
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Boolean> updateTask(@PathVariable Long id, @RequestBody TaskDto dto){
        return ResponseEntity.ok().body(taskService.updateTask(id, dto));
    }
}
