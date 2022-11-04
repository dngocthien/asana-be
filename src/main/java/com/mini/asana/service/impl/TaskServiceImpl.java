package com.mini.asana.service.impl;

import com.mini.asana.converter.TaskConverter;
import com.mini.asana.dto.GroupDto;
import com.mini.asana.dto.TaskDto;
import com.mini.asana.entity.Group;
import com.mini.asana.entity.Task;
import com.mini.asana.repo.GroupRepo;
import com.mini.asana.repo.TaskRepo;
import com.mini.asana.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskConverter taskConverter;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private GroupRepo groupRepo;

    @Override
    public Boolean saveTask(TaskDto dto) {
        System.out.println("TaskServiceImpl");
        System.out.println(dto.toString());
        taskRepo.save(taskConverter.toTask(dto));
        return true;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> taskList = taskRepo.findAll();
        return taskConverter.toDtoList(taskList);
    }

    @Override
    public Boolean updateTask(Long id, TaskDto dto) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null) {
            task.setName(dto.getName());
//            for (Long groupId : dto.getGroupIdList()) {
//                Group group = groupRepo.findById(groupId).orElse(null);
//                if (group != null) {
//                    task.getGroupList().add(group);
//                }
//            }
            taskRepo.save(task);
            return true;
        }
        return false;
    }
}