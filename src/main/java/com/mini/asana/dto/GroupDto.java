package com.mini.asana.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GroupDto {
    private Long id;
    private String name;
    private Long projectId;
    private List<TaskDto> taskList = new ArrayList<>();
}
