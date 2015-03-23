package com.leaves.framework.dao;

import com.leaves.framework.common.IOperations;
import com.leaves.framework.model.Role;

/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 16:49
 * Description:
 */
public interface IRoleDao extends IOperations<Role> {


    boolean isExisted(Role role);
}
