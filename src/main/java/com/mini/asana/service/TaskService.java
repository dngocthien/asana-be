package com.mini.asana.service;

import com.mini.asana.dto.TaskDto;
import com.mini.asana.entity.Task;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface TaskService {
    public Boolean saveTask(TaskDto dto);
    public List<TaskDto> getAllTasks();
}
