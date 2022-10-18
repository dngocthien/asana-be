package com.mini.asana.dto;

import com.mini.asana.entity.Group;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectDto {
    private Long id;
    private String name;
    private List<Group> groupList = new ArrayList<>();;
}
