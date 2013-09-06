/**
 * ClassName: TestSercurityController
 * CopyRight: TalkWeb
 * Date: 13-8-25
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.opensoft.common.utils.json.gson.GsonUtils;
import com.titian.cms.exception.ServiceException;
import com.titian.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description :
 *
 * @author : KangWei
 */
@Controller
public class TestSercurityController {
    private static final Logger log = LoggerFactory.getLogger(TestSercurityController.class);

    @RequestMapping("/allow")
    public String allow() {
        log.info("访问allow");
        return "allow";
    }

    @RequestMapping("/forbidden")
    public String forbidden() {
        log.info("访问forbidden");
        throw new ServiceException("我是错误");
    }

    @RequestMapping("/json")
    public @ResponseBody String json() {
        User user = new User();
        user.setUserId("123456");
        user.setUserNick("康维");
        String s = GsonUtils.toJson(user);
        log.info("输出的Json==={}", s);
        return s;
    }
}
