package com.leaves.framework.service.impl;

import com.leaves.framework.dao.IUserDao;
import com.leaves.framework.model.Role;
import com.leaves.framework.model.User;
import com.leaves.framework.service.IUserService;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: jiangq
 * Date: 2014/10/14
 * Time: 15:37
 * Description:
 */
@Service("userService")
@Transactional
public class UserService implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Override
    public User getUser(String id) {
        User user = userDao.findOne(id);
        Hibernate.initialize(user.getRoles());
        return user;
    }

    @Override
    public List<User> getUserList(int currentPage, int pageSize) {
        List<User> users = userDao.findAllByPage(currentPage, pageSize);
        return users;
    }

    @Override
    public String addUser(User user) {
        if (userDao.isExisted(user)) {
            return "existed";
        } else {
            userDao.create(user);
            return "ok";
        }
    }

    @Override
    public String update(User user) {
        if (userDao.isExisted(user)) {
            return "existed";
        } else if (user.getPassword() == null) {
            User oUser = userDao.findOne(user.getId());
            BeanUtils.copyProperties(user, oUser, "password");
            userDao.update(oUser);
            return "ok";
        } else {
            userDao.update(user);
            return "ok";
        }
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public String addOrUpdate(User user) {
        if (user.getId() == null)
            return this.addUser(user);
        else return this.update(user);
    }
}