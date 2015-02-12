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
    public User findOne(long id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    public List<User> getUserInfo() {
        return userDao.getUserInfo();
    }

    @Override
    public List<User> findAllByPage(int currentPage, int pageSize) {
        return userDao.findAllByPage(currentPage, pageSize);
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
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteById(long Id) {
        userDao.deleteById(Id);
    }
}