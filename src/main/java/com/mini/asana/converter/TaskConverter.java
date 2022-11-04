package com.mini.asana.converter;

import com.mini.asana.dto.GroupDto;
import com.mini.asana.dto.TaskDto;
import com.mini.asana.entity.Group;
import com.mini.asana.entity.Task;
import com.mini.asana.repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConverter {

    @Autowired
    private GroupConverter groupConverter;
    @Autowired
    private GroupRepo groupRepo;

    public TaskDto toTaskDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setAssignee(task.getAssignee());
        dto.setDescription(task.getDescription());
        dto.setDue(task.getDue());
        for (Group group : task.getGroups()) {
            GroupDto groupDto = groupConverter.toDto(group);
            dto.getGroupIdList().add(groupDto.getId());
        }
        return dto;
    }

    public Task toTask(TaskDto dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setAssignee(dto.getAssignee());
        task.setDescription(dto.getDescription());
        task.setDue(dto.getDue());
        for (Long groupId : dto.getGroupIdList()) {
            Group group = groupRepo.findById(groupId).orElse(null);
            if (group != null) {
                task.getGroups().add(group);
            }
        }
        return task;
    }

    public List<TaskDto> toDtoList(List<Task> taskList) {
        List<TaskDto> dtoList = new ArrayList<>();
        for (Task t : taskList) {
            dtoList.add(toTaskDto(t));
        }
        return dtoList;
    }
}
