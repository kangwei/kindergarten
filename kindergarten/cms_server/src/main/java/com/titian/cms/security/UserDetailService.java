package com.titian.cms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author KangWei
 * description： 加载用户
 */
@Service("UserDetailService")
public class UserDetailService implements UserDetailsService {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);
/*    @Inject
    com.alcor.acl.component.User user ;  */

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        if ("admin".equals(username)) {
            auths.add(new GrantedAuthorityImpl("admin"));
        } else if ("user".equals(username)) {
            auths.add(new GrantedAuthorityImpl("user"));
        }

        return new User(username, "1234", true, true, true, true, auths);
    }
}  