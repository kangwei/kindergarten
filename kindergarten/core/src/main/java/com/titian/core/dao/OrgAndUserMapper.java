package com.titian.core.dao;

import com.titian.core.domain.OrgAndUser;

public interface OrgAndUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgAndUser record);

    int insertSelective(OrgAndUser record);

    OrgAndUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgAndUser record);

    int updateByPrimaryKey(OrgAndUser record);
}