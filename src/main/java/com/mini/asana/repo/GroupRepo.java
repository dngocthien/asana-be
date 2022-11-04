package com.mini.asana.repo;

import com.mini.asana.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {
    List<Group> findByProjectId(Long id);
}
