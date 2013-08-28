/**
 * ClassName: TestEvent
 * CopyRight: TalkWeb
 * Date: 12-12-26
 * Version: 1.0
 */
package com.titian.core.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Description :
 *
 * @author : 康维
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader = MockServletContextWebContextLoader.class, locations = {"classpath:spring/applicationContext-*.xml", "classpath:applicationContext.xml"})
public class TestEvent1 {


    @Test
    public void testEvent() {
        String[] locations = {"classpath:spring/applicationContext-*.xml"};
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(locations);
        System.out.println(applicationContext.toString());
    }
}
