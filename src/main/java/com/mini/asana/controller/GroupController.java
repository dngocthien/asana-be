package com.mini.asana.controller;

import com.mini.asana.dto.GroupDto;
import com.mini.asana.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/groups/project/{id}")
    public ResponseEntity<List<GroupDto>> getGroupByProjectId(@PathVariable Long id){
        return ResponseEntity.ok().body(groupService.findGroupByProjectId(id));
    }

    @PostMapping("/groups")
    public ResponseEntity<GroupDto> saveGroup(@RequestBody GroupDto dto){
        return ResponseEntity.ok().body(groupService.saveGroup(dto));
    }

    @PutMapping("/groups/{id}")
    public ResponseEntity<GroupDto> updateGroup(@PathVariable Long id, @RequestBody GroupDto dto){
        return ResponseEntity.ok().body(groupService.updateGroup(id, dto));
    }
}
