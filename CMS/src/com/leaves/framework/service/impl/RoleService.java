package com.leaves.framework.service.impl;

import com.leaves.framework.model.Role;
import com.leaves.framework.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 15:53
 * Description:
 */
@Service("roleService")
@Transactional
public class RoleService implements IRoleService {
    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public String addOrUpdate(Role role) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
