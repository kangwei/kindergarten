/**
 * ClassName: RoleService
 * CopyRight: TalkWeb
 * Date: 13-8-24
 * Version: 1.0
 */
package com.titian.cms.web.service;

import com.titian.core.dao.RoleMapper;
import com.titian.core.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description :
 *
 * @author : KangWei
 */
@Service("RoleService")
public class RoleService {
    private static final Logger log = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    RoleMapper roleMapper;

    /*public List<Role> listAllRole() {
    }*/
}
