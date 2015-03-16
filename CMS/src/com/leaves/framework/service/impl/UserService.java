package com.leaves.framework.service.impl;

import com.leaves.framework.dao.IUserDao;
import com.leaves.framework.model.User;
import com.leaves.framework.service.IUserService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    public List<User> getUserList(int currentPage, int pageSize) {
        return userDao.getUserList(currentPage, pageSize);
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
        } else {
            User oUser = userDao.findOne(user.getId());
            BeanUtils.copyProperties(user, oUser, "id", "password", "departmentId", "organizationId", "state", "roles");
            userDao.update(oUser);
            return "ok";
        }
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}