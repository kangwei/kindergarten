/**
 * ClassName: MenuMapper
 * CopyRight: TalkWeb
 * Date: 13-9-4
 * Version: 1.0
 */
package com.titian.core.dao;

import com.titian.core.domain.Menu;

import java.util.List;

/**
 * Description :
 *
 * @author : KangWei
 */
public interface MenuMapper {
    List<Menu> getMenuByUserId(String userId);
}
