package com.titian.core.dao;

import com.titian.core.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    User selectByUserAccount(String userAccount);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 按条件分页查询用户
     *
     * @param param key-value，
     *              note：key的范围：Page类, userNick, userMobile, userType, status
     * @return 查询到的用户
     */
    List<User> list_user_page(Map<String, Object> param);
}