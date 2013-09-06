/**
 * ClassName: RoleController
 * CopyRight: TalkWeb
 * Date: 13-8-26
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.opensoft.common.web.PageContext;
import com.talkyun.apus.mybatis.plugin.Page;
import com.titian.cms.common.Constants;
import com.titian.cms.common.Result;
import com.titian.core.dao.RoleMapper;
import com.titian.core.domain.Role;
import com.titian.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description : 角色控制器
 *
 * @author : KangWei
 */
@Controller
@RequestMapping("role")
public class RoleController extends AbstractBaseController {
    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleMapper roleMapper;

    @RequestMapping(value = "/list_page", method = RequestMethod.GET)
    @ResponseBody
    public String list_page(@RequestParam(value = "currPage", defaultValue = "1") int currPage,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(value = "roleName", defaultValue = "") String roleName) {
        Map<String, Object> param = new HashMap<String, Object>();
        Page page = buildPage(currPage, pageSize);
        param.put(Constants.PAGE, page);
        param.put("roleName", roleName);
        List<Role> roles = roleMapper.list_role_page(param);
        return Result.success().setData("roles", roles)
                .setData("totalResult", page.getTotalResult())
                .setData("totalPage", page.getTotalPage())
                .toJson();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(Role role) {
        roleMapper.insert(role);
        return Result.success().toJson();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(Role role) {
        roleMapper.updateByPrimaryKey(role);
        return Result.success().toJson();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(Integer roleId) {
        roleMapper.deleteByPrimaryKey(roleId);
        return Result.success().toJson();
    }


}
