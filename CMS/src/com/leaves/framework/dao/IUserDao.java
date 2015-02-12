package com.leaves.framework.dao;

import com.leaves.framework.model.User;
import com.leaves.framework.common.dao.IOperations;

import java.util.List;

/**
 * Created by leaves on 2014/10/14.
 */
public interface IUserDao extends IOperations<User> {

    List<User> findByCode(final String code);

    List<User> getUserInfo();
}
