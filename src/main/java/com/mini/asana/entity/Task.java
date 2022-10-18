package com.mini.asana.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String assignee;
    private String description;
    private Date due;

    @ManyToMany
    private List<Group> groupList = new ArrayList<>();
}
