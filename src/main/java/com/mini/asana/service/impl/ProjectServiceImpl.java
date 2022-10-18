package com.mini.asana.service.impl;

import com.mini.asana.converter.ProjectConverter;
import com.mini.asana.dto.ProjectDto;
import com.mini.asana.entity.Project;
import com.mini.asana.repo.ProjectRepo;
import com.mini.asana.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private ProjectConverter projectConverter;

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectConverter.toDtoList(projectRepo.findAll());
    }

    @Override
    public boolean saveProject(ProjectDto dto) {
        projectRepo.save(projectConverter.toProject(dto));
        return true;
    }

    @Override
    public boolean deleteProject(long id) {
        Project project = projectRepo.findById(id).orElse(null);
        if (project != null) {
            projectRepo.delete(project);
            return true;
        }
        return false;
    }
}
