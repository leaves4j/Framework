package com.leaves.framework.service.impl;

import com.leaves.framework.dao.impl.UserDao;
import com.leaves.framework.model.User;
import com.leaves.framework.service.ILoginService;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: jiangq
 * Date: 2015/1/5
 * Time: 15:37
 * Description:
 */
@Service("loginService")
@Transactional
public class LoginService implements ILoginService {
    @Resource(name = "userDao")
    UserDao userDao;

    @Override
    public List<User> getUser(String code) {
        List<User> users = userDao.findByCode(code);
        for (User user : users) {
            Hibernate.initialize(user.getRoles());
        }
        return users;

    }
}
