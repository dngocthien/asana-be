package com.mini.asana.converter;

import com.mini.asana.dto.TaskDto;
import com.mini.asana.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConverter {
    public TaskDto toTaskDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setAssignee(task.getAssignee());
        dto.setDescription(task.getDescription());
        dto.setDue(task.getDue());
        dto.setGroupList(task.getGroupList());
        return dto;
    }

    public Task toTask(TaskDto dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setAssignee(dto.getAssignee());
        task.setDescription(dto.getDescription());
        task.setDue(dto.getDue());
        task.setGroupList(dto.getGroupList());
        return task;
    }

    public List<TaskDto> toDtoList(List<Task> taskList){
        List<TaskDto> dtoList = new ArrayList<>();
        for(Task t: taskList){
            dtoList.add(toTaskDto(t));
        }
        return dtoList;
    }
}
