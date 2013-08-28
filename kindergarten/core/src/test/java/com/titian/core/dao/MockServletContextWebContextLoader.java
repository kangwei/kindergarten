/**
 * ClassName: aa
 * CopyRight: TalkWeb
 * Date: 12-12-26
 * Version: 1.0
 */
package com.titian.core.dao;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.support.AbstractContextLoader;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Description :
 *
 * @author : 康维
 */
public class MockServletContextWebContextLoader extends AbstractContextLoader {
    private static ServletContext servletContext;
    @Override
    public final ConfigurableApplicationContext loadContext(String... locations) throws Exception {
        ConfigurableWebApplicationContext context = new XmlWebApplicationContext();
        context.setServletContext(new MockServletContext("/web", new FileSystemResourceLoader()));
        servletContext = context.getServletContext();
        context.setConfigLocations(locations);
        context.refresh();
        AnnotationConfigUtils.registerAnnotationConfigProcessors((BeanDefinitionRegistry) context.getBeanFactory());
        context.registerShutdownHook();
        return context;
    }

    @Override
    protected String getResourceSuffix() {
        return "*.xml";
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }
}