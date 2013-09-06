/**
 * ClassName: MenuMapperImpl
 * CopyRight: TalkWeb
 * Date: 13-9-4
 * Version: 1.0
 */
package com.titian.core.dao.impl;

import com.opensoft.common.cache.annotation.Cache;
import com.titian.core.dao.MenuMapper;
import com.titian.core.domain.Menu;
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
public class MenuMapperImpl implements MenuMapper {
    public static final String NAMESPACE = "com.titian.core.dao.MenuMapper.";

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    @Cache
    public List<Menu> getMenuByUserId(String userId) {
        return (List<Menu>) sqlSessionTemplate.selectList(NAMESPACE + "getMenuByUserId", userId);
    }
}
