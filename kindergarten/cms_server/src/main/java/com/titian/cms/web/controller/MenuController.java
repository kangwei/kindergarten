/**
 * ClassName: HomeController
 * CopyRight: TalkWeb
 * Date: 13-8-31
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.opensoft.common.utils.json.gson.GsonUtils;
import com.titian.cms.common.Result;
import com.titian.cms.security.LoginUser;
import com.titian.cms.web.service.UserService;
import com.titian.core.domain.Menu;
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
@RequestMapping("menu")
public class MenuController extends AbstractBaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "getUserMenu", method = RequestMethod.GET)
    @ResponseBody
    public String getUserMenu() {
        LoginUser sessionUser = getSessionUser();
        if (sessionUser != null) {
            Menu userMenu = userService.getUserMenu(sessionUser.getUserId());
            return Result.success().setData(userMenu).toJson();
        }
        return GsonUtils.EMPTY_JSON;
    }

}
