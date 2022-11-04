package com.mini.asana.service.impl;

import com.mini.asana.converter.ProjectConverter;
import com.mini.asana.dto.ProjectDto;
import com.mini.asana.entity.Group;
import com.mini.asana.entity.Project;
import com.mini.asana.repo.GroupRepo;
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
    private GroupRepo groupRepo;
    @Autowired
    private ProjectConverter projectConverter;

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepo.findAll();
//        for (Project project : projects) {
//            List<Group> groups = groupRepo.findByProjectId(project.getId());
//            for (Group group : groups) {
//                System.out.println(group.getName());
//                if (!project.getGroupList().contains(group)) {
//                    project.getGroupList().add(group);
//                }
//            }
//        }
        return projectConverter.toDtoList(projects);
    }

    @Override
    public boolean saveProject(ProjectDto dto) {
        System.out.println("ff");
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
