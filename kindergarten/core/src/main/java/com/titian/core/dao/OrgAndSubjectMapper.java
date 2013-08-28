package com.titian.core.dao;

import com.titian.core.domain.OrgAndSubject;

public interface OrgAndSubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgAndSubject record);

    int insertSelective(OrgAndSubject record);

    OrgAndSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgAndSubject record);

    int updateByPrimaryKey(OrgAndSubject record);
}