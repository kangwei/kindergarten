package com.titian.core.dao;

import com.titian.core.domain.RoleAndFunction;

import java.util.List;

public interface RoleAndFunctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleAndFunction record);

    int insertSelective(RoleAndFunction record);

    RoleAndFunction selectByPrimaryKey(Integer id);

    List<RoleAndFunction> listRoleFunctionByFunctionId(Integer functionId);

    int updateByPrimaryKeySelective(RoleAndFunction record);

    int updateByPrimaryKey(RoleAndFunction record);
}