/**
 * ClassName: UserRoleController
 * CopyRight: TalkWeb
 * Date: 13-9-5
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.titian.core.dao.UserRoleMapper;
import com.titian.core.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description :
 *
 * @author : KangWei
 */
@Controller
@RequestMapping("userRole")
public class UserRoleController extends AbstractBaseController {
    @Autowired
    UserRoleMapper userRoleMapper;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(UserRole userRole) {
        return effectiveResult(userRoleMapper.insert(userRole));
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String create(Integer userRoleId) {
        return effectiveResult(userRoleMapper.deleteByPrimaryKey(userRoleId));
    }
}
