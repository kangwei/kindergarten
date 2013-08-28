package com.titian.core.dao;

import com.titian.core.domain.OperateLog;

public interface OperateLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(OperateLog record);

    int insertSelective(OperateLog record);

    OperateLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(OperateLog record);

    int updateByPrimaryKey(OperateLog record);
}