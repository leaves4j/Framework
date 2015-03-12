package com.leaves.framework.service;


import com.leaves.framework.common.dao.IOperations;
import com.leaves.framework.model.User;

import java.util.List;


/**
 * Created by leaves on 2014/10/14.
 */
public interface IUserService extends IOperations<User> {


    List<User> getUserList(int currentPage, int pageSize);

    List<User> findAllByPage(final int currentPage, final int pageSize);

    String addUser(User user);
}
