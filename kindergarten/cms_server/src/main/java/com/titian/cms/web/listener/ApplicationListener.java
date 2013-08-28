/**
 * ClassName: ApplicationListener
 * CopyRight: TalkWeb
 * Date: 13-8-26
 * Version: 1.0
 */
package com.titian.cms.web.listener;

import com.opensoft.common.web.ApplicationServletContext;
import com.opensoft.common.web.PageContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Description : 系统启动监听
 *
 * @author : KangWei
 */
public class ApplicationListener implements HttpSessionListener, ServletContextListener, ServletRequestListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationServletContext.setContext(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        PageContext.setRequest((HttpServletRequest) sre.getServletRequest());
    }
}
