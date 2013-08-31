/**
 * ClassName: OperateLogService
 * CopyRight: TalkWeb
 * Date: 13-8-28
 * Version: 1.0
 */
package com.titian.cms.web.service;

import com.opensoft.common.web.PageContext;
import com.titian.cms.common.Constants;
import com.titian.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description : 操作日志服务d
 *
 * @author : KangWei
 */
@Service
public class OperateLogService {
    private static final Logger log = LoggerFactory.getLogger(OperateLogService.class);

    private static Map<String, String> serviceMap = new HashMap<String, String>();
    private static Map<String, String> operateMap = new HashMap<String, String>();

    static {
        serviceMap.put("LoginController", "登录服务");
        serviceMap.put("RoleController", "角色服务");

        operateMap.put("create", "新增");
        operateMap.put("doLogin", "登录");
    }

    public void addOperateLog(String service, String operate, String args) {
        User sessionUser = PageContext.getSessionValue(Constants.SESSION_USER_KEY);
//        log.info("{}用户访问{}，执行{}操作，参数：{}",
//                new Object[]{
//                        sessionUser.getUserId(), serviceMap.get(service), operateMap.get(operate), args
//                });
    }
}
