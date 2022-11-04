package com.mini.asana.service;

import com.mini.asana.converter.GroupConverter;
import com.mini.asana.dto.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface GroupService {
    public GroupDto saveGroup(GroupDto dto);

    public List<GroupDto> findGroupByProjectId(Long id);

    public GroupDto updateGroup(Long id, GroupDto dto);
}
