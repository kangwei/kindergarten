package com.titian.core.dao;

import com.titian.core.domain.SubjectAndRole;

public interface SubjectAndRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectAndRole record);

    int insertSelective(SubjectAndRole record);

    SubjectAndRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectAndRole record);

    int updateByPrimaryKey(SubjectAndRole record);
}