package com.titian.cms.security;

import com.opensoft.common.utils.CollectionUtils;
import com.opensoft.common.utils.StringUtils;
import com.titian.core.dao.FunctionMapper;
import com.titian.core.dao.RoleAndFunctionMapper;
import com.titian.core.domain.Function;
import com.titian.core.domain.RoleAndFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private static final Logger log = LoggerFactory.getLogger(InvocationSecurityMetadataSourceService.class);

    private static Map<String, Collection<ConfigAttribute>> resourceMap;

    @Autowired
    RoleAndFunctionMapper roleAndFunctionMapper;

    @Autowired
    FunctionMapper functionMapper;

    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
    /**
     * 加载资源的权限
     *
     * @throws Exception 异常
     */
    public void loadResourceDefine() throws Exception {
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

        //通过数据库中的信息设置，resouce和role  
        List<Function> functions = functionMapper.listAllFunction();
        if (CollectionUtils.isNotEmpty(functions)) {
//            if (log.isDebugEnabled()) {
//                log.debug("加载资源信息：{}", functions);
//            }
            for (Function function : functions) {
                Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                List<RoleAndFunction> roleAndFunctions = roleAndFunctionMapper.listRoleFunctionByFunctionId(function.getFunctionId());
                if (CollectionUtils.isNotEmpty(roleAndFunctions)) {
                    if (log.isDebugEnabled()) {
                        log.debug("为资源：{}加载可访问的角色信息：{}", function, roleAndFunctions);
                    }
                    for (RoleAndFunction roleAndFunction : roleAndFunctions) {
                        ConfigAttribute ca = new SecurityConfig(String.valueOf(roleAndFunction.getRoleId()));
                        atts.add(ca);
                    }
                }
                resourceMap.put(function.getUrl(), atts);
            }
        }

        //通过硬编码设置，resouce和role
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("admin");
        atts.add(ca);
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
        url = StringUtils.substringBefore(url, "?");

        boolean contains = resourceMap.keySet().contains(url);
        if (log.isDebugEnabled()) {
            log.debug("匹配资源：{}，匹配结果：{}", url, contains);
        }
        if (contains) {
            return resourceMap.get(url);
        }

        return null;
    }

    private boolean pathMatchesUrl(String url, String resURL) {
        boolean isMatch = false;
        // url匹配
        if (urlMatcher.pathMatchesUrl(url, resURL)) {
            isMatch = true;
        }
        if (log.isDebugEnabled()) {
            log.debug("匹配资源：{}和{}，匹配结果：{}", new Object[]{
                    url, resURL, isMatch
            });
        }
        return isMatch;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}   