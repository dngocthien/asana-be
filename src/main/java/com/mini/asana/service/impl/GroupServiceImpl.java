package com.mini.asana.service.impl;

import com.mini.asana.converter.GroupConverter;
import com.mini.asana.dto.GroupDto;
import com.mini.asana.entity.Group;
import com.mini.asana.repo.GroupRepo;
import com.mini.asana.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private GroupConverter groupConverter;

    @Override
    public List<GroupDto> findGroupByProjectId(Long id) {
        List<Group> groups = groupRepo.findByProjectId(id);
        return groupConverter.toDtoList(groups);
    }

    @Override
    public GroupDto saveGroup(GroupDto dto) {
        Group group = groupRepo.save(groupConverter.toGroup(dto));
        return groupConverter.toDto(group);
    }

    @Override
    public GroupDto updateGroup(Long id, GroupDto dto) {
        Group group = groupRepo.findById(dto.getId()).orElse(null);
        if (group != null) {
            group.setName(dto.getName());
            Group res = groupRepo.save(group);
            return groupConverter.toDto(res);
        }
        return null;
    }
}
