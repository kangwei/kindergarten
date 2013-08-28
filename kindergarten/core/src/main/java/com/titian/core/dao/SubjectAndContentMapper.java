package com.titian.core.dao;

import com.titian.core.domain.SubjectAndContent;

public interface SubjectAndContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectAndContent record);

    int insertSelective(SubjectAndContent record);

    SubjectAndContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectAndContent record);

    int updateByPrimaryKey(SubjectAndContent record);
}