package com.leaves.framework.service;


import com.leaves.framework.common.dao.IOperations;
import com.leaves.framework.model.User;

import java.util.List;


/**
 * Created by leaves on 2014/10/14.
 */
public interface IUserService extends IOperations<User> {


    List<User> getUserInfo();

    List<User> findAllByPage(final int currentPage, final int pageSize);
}
