package com.titian.core.dao;

import com.titian.core.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据条件查询角色
     *
     * @param param 查询条件 note：key的范围，Page类，roleName
     * @return 角色
     */
    List<Role> list_role_page(Map<String, Object> param);
}