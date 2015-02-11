package com.leaves.framework.service;

import com.leaves.framework.model.User;

import java.util.List;

/**
 * Created by jiangq on 2015/1/5.
 */
public interface ILoginService {

    List<User> getUser(final String code);
}
