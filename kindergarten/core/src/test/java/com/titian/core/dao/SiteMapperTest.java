/**
 * ClassName: SiteMapperTest
 * CopyRight: TalkWeb
 * Date: 13-8-7
 * Version: 1.0
 */
package com.titian.core.dao;

import com.titian.core.domain.Site;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description :
 *
 * @author : KangWei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml", "classpath*:spring/apus-datasource-druid.xml"})
public class SiteMapperTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    SiteMapper siteMapper;
    Site site;

    @org.junit.Before
    public void setUp() throws Exception {
//        siteMapper = (SiteMapper) applicationContext.getBean("siteMapper");
//        System.out.println(siteMapper);

        site = new Site();
        site.setSiteName("测试站点");
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testCountByExample() throws Exception {

    }

    @org.junit.Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @org.junit.Test
    public void testInsert() throws Exception {
        siteMapper.insert(site);
    }

    @org.junit.Test
    public void testSelectByPrimaryKey() throws Exception {
        Site site1 = siteMapper.selectByPrimaryKey(2);
        site1.setSiteName("更改");
        siteMapper.updateByPrimaryKey(site1);
        Site site2 = siteMapper.selectByPrimaryKey(2);
        Site site3 = siteMapper.selectByPrimaryKey(2);
        System.out.println(site2.getSiteName());
    }

    @Test
    public void testDynamicQueryCache() {
        Map<String, String> param = new HashMap<String, String>();
        List<Site> sites = siteMapper.selectByName(param);
        List<Site> sites1 = siteMapper.selectByName(param);
        param.put("siteName", "更改");
        siteMapper.selectByName(param);
        siteMapper.selectByName(param);
        param.put("siteName", "更改1");
        siteMapper.selectByName(param);
        siteMapper.selectByName(param);
        param.clear();
        siteMapper.selectByName(param);
        siteMapper.selectByName(null);
    }

    @org.junit.Test
    public void testUpdateByPrimaryKey() throws Exception {
        site.setSiteName("更改测试站点");
        siteMapper.updateByPrimaryKey(site);
    }
}
