package com.leaves.framework.dao.impl;

import com.leaves.framework.common.dao.AbstractHibernateDao;
import com.leaves.framework.dao.IRoleDao;
import com.leaves.framework.model.Role;
import org.springframework.stereotype.Repository;


/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 16:58
 * Description:
 */
@Repository("roleDao")
public class RoleDao extends AbstractHibernateDao<Role> implements IRoleDao {
    public RoleDao(){
        super();
        setClass(Role.class);
    }

}
