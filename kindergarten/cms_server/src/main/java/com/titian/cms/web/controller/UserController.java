/**
 * ClassName: UserController
 * CopyRight: TalkWeb
 * Date: 13-8-9
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.titian.cms.web.service.UserService;
import com.titian.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description :
 *
 * @author : KangWei
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(User user) {
        userService.createUser(user);
        return "";
    }
}
