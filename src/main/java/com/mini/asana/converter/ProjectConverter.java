package com.mini.asana.converter;

import com.mini.asana.dto.ProjectDto;
import com.mini.asana.dto.TaskDto;
import com.mini.asana.entity.Project;
import com.mini.asana.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectConverter {
    public ProjectDto toProjectDto(Project project) {
        ProjectDto dto = new ProjectDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
//        dto.setGroupList(project.getGroupList());
        return dto;
    }

    public Project toProject(ProjectDto dto) {
        Project project = new Project();
        project.setName(dto.getName());
        return project;
    }

    public List<ProjectDto> toDtoList(List<Project> projectList){
        List<ProjectDto> dtoList = new ArrayList<>();
        for(Project project: projectList){
            dtoList.add(toProjectDto(project));
        }
        return dtoList;
    }

    public List<Project> toProjectList(List<ProjectDto> dtoList){
        List<Project> projectList = new ArrayList<>();
        for(ProjectDto dto: dtoList){
            projectList.add(toProject(dto));
        }
        return projectList;
    }
}
