/**
 * ClassName: RoleAndFunctionMapperImpl
 * CopyRight: TalkWeb
 * Date: 13-9-4
 * Version: 1.0
 */
package com.titian.core.dao.impl;

import com.opensoft.common.cache.annotation.CacheClear;
import com.titian.core.dao.RoleAndFunctionMapper;
import com.titian.core.domain.RoleAndFunction;
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
public class RoleAndFunctionMapperImpl implements RoleAndFunctionMapper {

    public static final String NAMESPACE = "com.titian.core.dao.RoleAndFunctionMapper.";

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    @CacheClear(relatedCacheClass = {MenuMapperImpl.class}, allClear = true)
    public int deleteByPrimaryKey(Integer id) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteByPrimaryKey", id);
    }

    @Override
    @CacheClear(relatedCacheClass = {MenuMapperImpl.class}, allClear = true)
    public int insert(RoleAndFunction record) {
        return sqlSessionTemplate.insert(NAMESPACE + "insert", record);
    }

    @Override
    public int insertSelective(RoleAndFunction record) {
        return sqlSessionTemplate.insert(NAMESPACE + "insertSelective", record);
    }

    @Override
    public RoleAndFunction selectByPrimaryKey(Integer id) {
        return (RoleAndFunction) sqlSessionTemplate.selectOne(NAMESPACE + "selectByPrimaryKey", id);
    }

    @Override
    public List<RoleAndFunction> listRoleFunctionByFunctionId(Integer functionId) {
        return (List<RoleAndFunction>) sqlSessionTemplate.selectList(NAMESPACE + "listRoleFunctionByFunctionId", functionId);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleAndFunction record) {
        return sqlSessionTemplate.update(NAMESPACE + "updateByPrimaryKeySelective", record);
    }

    @Override
    @CacheClear(relatedCacheClass = {MenuMapperImpl.class}, allClear = true)
    public int updateByPrimaryKey(RoleAndFunction record) {
        return sqlSessionTemplate.update(NAMESPACE + "updateByPrimaryKey", record);
    }
}
