package com.mini.asana.converter;

import com.mini.asana.dto.GroupDto;
import com.mini.asana.dto.TaskDto;
import com.mini.asana.entity.Group;
import com.mini.asana.entity.Task;
import com.mini.asana.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupConverter {
    @Autowired
    private ProjectRepo projectRepo;

    public GroupDto toDto (Group group){
        GroupDto dto = new GroupDto();
        dto.setId(group.getId());
        dto.setName(group.getName());
        dto.setProjectId(group.getProject().getId());
        for(Task task: group.getTasks()){
            TaskDto taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setName(task.getName());
            dto.getTaskList().add(taskDto);
        }
        return dto;
    }

    public Group toGroup (GroupDto dto){
        Group group = new Group();
        group.setName(dto.getName());
        group.setProject(projectRepo.findById(dto.getProjectId()).orElse(null));
        return group;
    }

    public List<GroupDto> toDtoList(List<Group> groupList){
        List<GroupDto> dtos = new ArrayList<>();
        for(Group group:groupList){
            dtos.add(toDto(group));
        }
        return dtos;
    }
}
