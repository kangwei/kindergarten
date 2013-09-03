/**
 * ClassName: HomeController
 * CopyRight: TalkWeb
 * Date: 13-8-31
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.opensoft.common.web.PageContext;
import com.titian.cms.common.Constants;
import com.titian.core.domain.User;
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
public class HomeController {

    @RequestMapping(value = "getMenu", method = RequestMethod.GET)
    @ResponseBody
    public String getMenu() {
        User sessionUser = PageContext.getSessionValue(Constants.SESSION_USER_KEY);
        return "";
    }
}
