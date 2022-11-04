package com.mini.asana.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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

//    @Cascade({
//            org.hibernate.annotations.CascadeType.SAVE_UPDATE,
//            org.hibernate.annotations.CascadeType.MERGE,
//            org.hibernate.annotations.CascadeType.PERSIST
//    })
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "group_task",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Collection<Group> groups = new ArrayList<>();
}
