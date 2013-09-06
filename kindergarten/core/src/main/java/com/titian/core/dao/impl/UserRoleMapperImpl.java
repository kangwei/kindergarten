/**
 * ClassName: UserRoleMapperImpl
 * CopyRight: TalkWeb
 * Date: 13-9-4
 * Version: 1.0
 */
package com.titian.core.dao.impl;

import com.opensoft.common.cache.annotation.CacheClear;
import com.titian.core.dao.UserRoleMapper;
import com.titian.core.domain.UserRole;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description :
 *
 * @author : KangWei
 */
@Repository
public class UserRoleMapperImpl implements UserRoleMapper {
    public static final String NAMESPACE = "com.titian.core.dao.UserRoleMapper.";

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    @CacheClear(relatedCacheClass = {MenuMapperImpl.class}, allClear = true)
    public int deleteByPrimaryKey(Integer id) {
        return sqlSessionTemplate.delete(NAMESPACE + "", id);
    }

    @Override
    @CacheClear(relatedCacheClass = {MenuMapperImpl.class}, key = "#record.getUserId()")
    public int insert(UserRole record) {
        return sqlSessionTemplate.insert(NAMESPACE + "insert", record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return sqlSessionTemplate.insert(NAMESPACE + "insertSelective", record);
    }

    @Override
    public UserRole selectByPrimaryKey(Integer id) {
        return (UserRole) sqlSessionTemplate.selectOne(NAMESPACE + "selectByPrimaryKey", id);
    }

    @Override
    public List<UserRole> listUserRole(String userId) {
        return (List<UserRole>) sqlSessionTemplate.selectList(NAMESPACE + "listUserRole", userId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return sqlSessionTemplate.update(NAMESPACE + "updateByPrimaryKeySelective", record);
    }

    @Override
    @CacheClear(relatedCacheClass = {MenuMapperImpl.class}, key = "#record.getUserId()")
    public int updateByPrimaryKey(UserRole record) {
        return sqlSessionTemplate.update(NAMESPACE + "updateByPrimaryKey", record);
    }
}
