package com.titian.cms.security;

import com.titian.core.dao.UserMapper;
import com.titian.core.dao.UserRoleMapper;
import com.titian.core.domain.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author KangWei
 *         description： 加载用户
 */
@Service("UserDetailService")
public class UserDetailService implements UserDetailsService {
    /**
     * Logger for this class
     */
    private static final Logger log = LoggerFactory.getLogger(UserDetailService.class);
/*    @Inject
    com.alcor.acl.component.User user ;  */

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        com.titian.core.domain.User user = userMapper.selectByUserAccount(username);

        //查询用户及用户的角色
        if (user != null) {
            if (!"0".equals(user.getStatus())) {
                return new User(username, user.getUserPassword(), false, true, true, true, auths);
            }
            List<UserRole> userRoles = userRoleMapper.listUserRole(user.getUserId());
            for (UserRole userRole : userRoles) {
                auths.add(new GrantedAuthorityImpl(String.valueOf(userRole.getRoleId())));
            }
            if (log.isDebugEnabled()) {
                log.debug("查找到用户：{}，用户的角色：{}", user, userRoles);
            }
            return new User(username, user.getUserPassword(), true, true, true, true, auths);
        }

        throw new UsernameNotFoundException(username + "的用户不存在");
    }
}  