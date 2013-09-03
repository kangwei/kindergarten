/**
 * ClassName: LoginInterceptor
 * CopyRight: TalkWeb
 * Date: 13-8-31
 * Version: 1.0
 */
package com.titian.cms.web.interceptor;

import com.opensoft.common.web.PageContext;
import com.titian.cms.common.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description : 登录检查拦截器
 *
 * @author : KangWei
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (PageContext.getSessionValue(Constants.SESSION_USER_KEY) == null) {
            response.sendRedirect(request.getContextPath());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
