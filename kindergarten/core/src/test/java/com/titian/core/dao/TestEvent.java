/**
 * ClassName: TestEvent
 * CopyRight: TalkWeb
 * Date: 12-12-26
 * Version: 1.0
 */
package com.titian.core.dao;

import com.opensoft.common.event.core.EventThreadPoolMonitor;
import com.opensoft.common.web.WebAppContextUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.ServletContext;

/**
 * Description :
 *
 * @author : 康维
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = MockServletContextWebContextLoader.class, locations = {"classpath*:spring/applicationContext-*.xml","classpath*:spring/apus-datasource-c3p0.xml"})
public class TestEvent extends AbstractJUnit4SpringContextTests {

    @Test
    public void testEvent() {
        ServletContext servletContext = MockServletContextWebContextLoader.getServletContext();
        System.out.println(servletContext);
        MockServletContext mockServletContext = new MockServletContext();
        WebAppContextUtils.init(servletContext);
//        EventComponent.getInstance().start();

        /*String[] locations = {"classpath:spring/applicationContext-*.xml", "classpath:applicationContext.xml"};
        applicationContext = new FileSystemXmlApplicationContext(locations);
        testTeacherServiceClient = (TestTeacherServiceClient) applicationContext.getBean(TestTeacherServiceClient.class);*/
//        WebAppContext webAppContext = WebAppContextUtils.getWebAppContext();
//        System.out.println(webAppContext.getApplicationContext());

//        TestTeacherService testTeacherService = (TestTeacherService) WebAppContextUtils.getWebAppContext().getApplicationContext().getBean("TestTeacherService");
//        testTeacherServiceClient = (ITeacherServiceClient) applicationContext.getBean("testTeacherServiceClient");
        SiteMapper siteMapper = (SiteMapper) applicationContext.getBean("siteMapper");
        System.out.println(siteMapper);
        siteMapper.selectByPrimaryKey(1);
        EventThreadPoolMonitor.show();
//        System.out.println("========" + testTeacherService.getTeacher("123456", "1").toString());
    }
}
