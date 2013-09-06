/**
 * ClassName: UserController
 * CopyRight: TalkWeb
 * Date: 13-8-9
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.opensoft.common.web.PageContext;
import com.talkyun.apus.mybatis.plugin.Page;
import com.titian.cms.common.Constants;
import com.titian.cms.common.ErrorCode;
import com.titian.cms.common.Result;
import com.titian.core.dao.UserMapper;
import com.titian.core.domain.User;
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
 * Description : 用户控制器，基本的CURD
 *
 * @author : KangWei
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "list_page", method = RequestMethod.GET)
    @ResponseBody
    public String list_page(@RequestParam(value = "currPage", defaultValue = "1") int currPage,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                            @RequestParam(value = "userNick", defaultValue = "") String userNick,
                            @RequestParam(value = "userType", defaultValue = "") String userType,
                            @RequestParam(value = "userMobile", defaultValue = "") String userMobile,
                            @RequestParam(value = "status", defaultValue = "") String status) {
        Map<String, Object> param = new HashMap<String, Object>();
        Page page = buildPage(currPage, pageSize);
        param.put(Constants.PAGE, page);
        param.put("userNick", userNick);
        param.put("userType", userType);
        param.put("userMobile", userMobile);
        param.put("status", status);
        List<User> users = userMapper.list_user_page(param);
        return Result.success().setData("users", users)
                .setData("totalResult", page.getTotalResult())
                .setData("totalPage", page.getTotalPage())
                .toJson();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(User user) {
        int row = userMapper.insert(user);
        return effectiveResult(row);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String update(User user) {
        int row = userMapper.updateByPrimaryKey(user);
        return effectiveResult(row);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String userId) {
        int row = userMapper.deleteByPrimaryKey(userId);
        return effectiveResult(row);
    }
}
