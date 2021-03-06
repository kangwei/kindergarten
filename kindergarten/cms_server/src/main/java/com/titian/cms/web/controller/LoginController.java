/**
 * ClassName: LoginController
 * CopyRight: TalkWeb
 * Date: 13-8-26
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.opensoft.common.web.PageContext;
import com.titian.cms.common.Constants;
import com.titian.cms.common.Result;
import com.titian.cms.security.LoginUser;
import com.titian.core.dao.UserMapper;
import com.titian.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description : 登录控制器
 *
 * @author : KangWei
 */
@Controller
public class LoginController extends AbstractBaseController{
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home() {
        LoginUser userDetails = getSessionUser();
        if (userDetails == null) {
            return "login";
        }
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        return "login";
    }

    @Deprecated
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(@RequestParam(required = true) String userAccount,
                          @RequestParam(required = true) String userPassword,
                          Model model) {
        User queriedUser = userMapper.selectByUserAccount(userAccount);

        if (queriedUser != null && queriedUser.getUserPassword().equals(userPassword)) {
            PageContext.setSessionValue(Constants.SESSION_USER_KEY, queriedUser);
            return Result.success().toJson();
        }
        model.addAttribute("msg", "用户名与密码不匹配");
        return Result.fail("登陆失败").toJson();
    }
}
