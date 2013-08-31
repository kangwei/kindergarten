package com.titian.core.dao;

import com.titian.core.domain.Function;

import java.util.List;

public interface FunctionMapper {
    int deleteByPrimaryKey(Integer functionId);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer functionId);

    List<Function> listAllFunction();

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
}