package com.leaves.framework.dao.impl;

import com.leaves.framework.dao.IUserDao;
import com.leaves.framework.model.User;
import com.leaves.framework.common.dao.AbstractHibernateDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by leaves on 2014/10/14.
 */
@Repository("userDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {
    public UserDao() {
        super();
        setClass(User.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findByCode(String code) {
        return this.getCurrentSession()
                .createQuery("from User user where user.code= ?")
                .setString(0, code)
                .list();

    }

    @SuppressWarnings("unchecked")
    public List<User> getUserList(int currentPage, int pageSize) {
        return this.getCurrentSession()
                .createQuery("select new User(id, code, name, email, description, createTime, state) from User")
                .setFirstResult((currentPage-1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }
}
