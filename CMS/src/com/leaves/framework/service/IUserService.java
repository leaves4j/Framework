package com.leaves.framework.service;


import com.leaves.framework.model.User;

import java.util.List;


/**
 * Created by leaves on 2014/10/14.
 */
public interface IUserService {

    /**
     * 分页获取用户列表
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return 用户列表
     */
    List<User> getUserList(int currentPage, int pageSize);

    /**
     * 新增一个用户
     *
     * @param user 用户实体
     * @return existed/ok
     */
    String addUser(User user);

    /**
     * 根据id删除用书
     *
     * @param id 用户id
     */
    void deleteById(String id);

    /**
     * 更新用户信息
     *
     * @param user 用户实体
     * @return existed/ok
     */
    String update(User user);
}
