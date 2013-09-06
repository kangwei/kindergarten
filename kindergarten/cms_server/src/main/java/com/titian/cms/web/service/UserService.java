/**
 * ClassName: UserService
 * CopyRight: TalkWeb
 * Date: 13-8-9
 * Version: 1.0
 */
package com.titian.cms.web.service;

import com.opensoft.common.exception.AppException;
import com.opensoft.common.utils.TreeCreator;
import com.titian.core.dao.MenuMapper;
import com.titian.core.dao.UserMapper;
import com.titian.core.domain.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description :
 *
 * @author : KangWei
 */
@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    MenuMapper menuMapper;

    public Menu getUserMenu(String userId) {
        List<Menu> menuByUserId = menuMapper.getMenuByUserId(userId);
        Menu root = new Menu();
        root.setFunctionId(0);
        try {
            root = TreeCreator.createTree(menuByUserId, root, "functionId", "parentId", "children");
        } catch (AppException e) {
            log.error("生成菜单树异常", e);
        }

        return root;
    }
}
