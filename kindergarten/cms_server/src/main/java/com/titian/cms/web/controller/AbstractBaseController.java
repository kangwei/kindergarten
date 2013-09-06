/**
 * ClassName: AbstractBaseController
 * CopyRight: TalkWeb
 * Date: 13-9-3
 * Version: 1.0
 */
package com.titian.cms.web.controller;

import com.opensoft.common.utils.StringUtils;
import com.talkyun.apus.mybatis.plugin.Page;
import com.titian.cms.common.ErrorCode;
import com.titian.cms.common.Result;
import com.titian.cms.security.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Description : 基础控制器
 *
 * @author : KangWei
 */
public abstract class AbstractBaseController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        url = StringUtils.removeEnd(url, "/index");
        url = StringUtils.substringAfterLast(url, "/");
        if (StringUtils.isNotEmpty(url)) {
            return url + "/index";
        }

        return "index";
    }

    protected LoginUser getSessionUser() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        LoginUser loginUser = null;
        if (principal instanceof LoginUser) {
            loginUser = (LoginUser) principal;
        }

        return loginUser;
    }

    protected Page buildPage(int currPage, int pageSize) {
        Page page = new Page();
        page.setCurrentPage(currPage);
        page.setShowCount(pageSize);
        return page;
    }

    protected boolean isSuccess(int effectiveRow) {
        return effectiveRow > 0;
    }

    protected String effectiveResult(int row) {
            if (isSuccess(row)) {
                return Result.success().toJson();
            }

            return Result.fail(ErrorCode.database_no_row_effect.getDesc()).toJson();
        }
}
