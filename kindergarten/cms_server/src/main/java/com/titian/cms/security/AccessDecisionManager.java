package com.titian.cms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author KangWei
 * @desciption 访问决策管理器，决定用户是否对资源具有访问的权限
 */
@Service("AccessDecisionManager")
public class AccessDecisionManager implements org.springframework.security.access.AccessDecisionManager {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(AccessDecisionManager.class);

    /**
     * @param authentication   认证信息
     * @param object           访问资源
     * @param configAttributes 权限配置
     * @throws AccessDeniedException 权限拒绝异常
     * @throws InsufficientAuthenticationException
     *                               异常
     */
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (logger.isDebugEnabled()) {
            logger.debug("decide({}, {}, ) - start", authentication, object);
        }

        if (configAttributes == null) { //资源权限为空
            return;
        }

        for (ConfigAttribute ca : configAttributes) {
            String needRole = ca.getAttribute();
            if (needRole == null) { //资源没有配置任何权限信息
                logger.warn("{}资源没有配置任何权限，将不做权限控制", object.toString());
                return;
            }

            if (logger.isDebugEnabled()) {
                logger.debug("资源需要的角色[{}]，用户角色[{}]", needRole, authentication.getAuthorities());
            }

            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (logger.isDebugEnabled()) {
                    logger.debug("用户的角色[{}]", ga.getAuthority());
                }

                if (needRole.equals(ga.getAuthority())) { // 匹配放行
                    return;
                }
            }
        }
        throw new AccessDeniedException("没有权限");
    }

    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
}   