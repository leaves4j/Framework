package com.leaves.framework.service.impl;

import com.leaves.framework.dao.IRoleDao;
import com.leaves.framework.model.Role;
import com.leaves.framework.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    @Resource(name = "roleDao")
    IRoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public String addOrUpdate(Role role) {
        if (role.getId() == null && roleDao.isExisted(role))
            return "existed";
        else {
            roleDao.createOrUpdate(role);
            return "ok";
        }
    }

    @Override
    public void deleteById(String id) {
        roleDao.deleteById(id);
    }
}
