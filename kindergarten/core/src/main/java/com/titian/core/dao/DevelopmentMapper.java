package com.titian.core.dao;

import com.titian.core.domain.Development;

public interface DevelopmentMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(Development record);

    int insertSelective(Development record);

    Development selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(Development record);

    int updateByPrimaryKey(Development record);
}