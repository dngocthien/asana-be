package com.mini.asana.dto;

import com.mini.asana.entity.Group;
import lombok.Data;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TaskDto {
    private Long id;
    private String name;
    private String assignee;
    private String description;
    private Date due;
    private List<Long> groupIdList = new ArrayList<>();
}
