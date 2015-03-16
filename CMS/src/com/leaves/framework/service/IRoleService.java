package com.leaves.framework.service;

import com.leaves.framework.model.Role;

import java.util.List;

/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 15:40
 * Description:
 */
public interface IRoleService {
    List<Role> findAll();

    String addOrUpdate(Role role);

    void deleteById(String id);

}
