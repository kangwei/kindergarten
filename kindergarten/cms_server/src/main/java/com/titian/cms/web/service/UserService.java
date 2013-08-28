/**
 * ClassName: UserService
 * CopyRight: TalkWeb
 * Date: 13-8-9
 * Version: 1.0
 */
package com.titian.cms.web.service;

import com.titian.core.dao.UserMapper;
import com.titian.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :
 *
 * @author : KangWei
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void createUser(User user) {
        userMapper.insert(user);
    }
}
