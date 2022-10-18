package com.mini.asana.service;

import com.mini.asana.dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public List<ProjectDto> getAllProjects();
    public boolean saveProject(ProjectDto dto);

    public boolean deleteProject(long id);
}
