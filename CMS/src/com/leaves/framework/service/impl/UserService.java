package com.leaves.framework.service.impl;

import com.leaves.framework.dao.IUserDao;
import com.leaves.framework.model.User;
import com.leaves.framework.service.IUserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by leaves on 2014/10/14.
 */
@Service("userService")
@Transactional
public class UserService implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;


    @Override
    public User findOne(String id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> getUserList(int currentPage, int pageSize) {
        return userDao.getUserList(currentPage, pageSize);
    }

    @Override
    public List<User> findAllByPage(int currentPage, int pageSize) {
        return userDao.findAllByPage(currentPage, pageSize);
    }
    @Override

    public String addUser(User user) {
        List<User> list = userDao.findByCode(user.getCode());
        if (list.size() == 0) {
            userDao.create(user);
            return "ok";
        } else return "existed";
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public User createOrUpdate(User user) {
        return userDao.createOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteById(String Id) {
        userDao.deleteById(Id);
    }
}