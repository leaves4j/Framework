package com.leaves.framework.dao.impl;

import com.leaves.framework.common.dao.AbstractHibernateDao;
import com.leaves.framework.dao.IFunctionDao;
import com.leaves.framework.model.Function;
import org.springframework.stereotype.Repository;

/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 15:18
 * Description:
 */
@Repository("functionDao")
public class FunctionDao extends AbstractHibernateDao<Function> implements IFunctionDao {
    public FunctionDao() {
        super();
        setClass(Function.class);
    }

    @Override
    public void deleteChildren(String id) {
        this.getCurrentSession()
                .createQuery("delete from Function where path=?")
                .setString(0, id);
    }
}
