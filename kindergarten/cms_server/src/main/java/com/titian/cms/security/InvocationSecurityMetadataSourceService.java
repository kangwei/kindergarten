package com.titian.cms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KangWei
 * @version 1.0
 * @desciption 资源权限加载器
 */
@Service("InvocationSecurityMetadataSourceService")
public class InvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(InvocationSecurityMetadataSourceService.class);

    private static Map<String, Collection<ConfigAttribute>> resourceMap;

    /**
     * 加载资源的权限
     *
     * @throws Exception 异常
     */
    public void loadResourceDefine() throws Exception {
        this.resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

        //通过数据库中的信息设置，resouce和role  


        //通过硬编码设置，resouce和role
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("admin");
        atts.add(ca);
        resourceMap.put("/allow", atts);
        resourceMap.put("/forbidden", atts);

        atts = new ArrayList<ConfigAttribute>();
        ca = new SecurityConfig("user");
        atts.add(ca);
        resourceMap.put("/allow", atts);
    }

    /**
     * 找出资源可以访问的权限列表
     *
     * @param object 资源
     * @return 权限列表
     * @throws IllegalArgumentException 异常
     */
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // guess object is a URL.
        String url = ((FilterInvocation) object).getRequestUrl();

        for (String resURL : resourceMap.keySet()) {
            if (pathMatchesUrl(url, resURL)) {
                return resourceMap.get(resURL);
            }
        }

        return null;
    }

    private boolean pathMatchesUrl(String url, String resURL) {
        //todo : url匹配
        return false;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}   