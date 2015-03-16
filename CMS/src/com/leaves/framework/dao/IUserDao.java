package com.leaves.framework.dao;

import com.leaves.framework.model.User;
import com.leaves.framework.common.IOperations;

import java.util.List;

/**
 * Created by leaves on 2014/10/14.
 */
public interface IUserDao extends IOperations<User> {
    /**
     * 根据code获取user
     *
     * @param code code
     * @return user
     */
    List<User> findByCode(final String code);

    /**
     * 获取user列表
     *
     * @param currentPage 当前页
     * @param pageSize    分页大小
     * @return user列表
     */
    List<User> getUserList(int currentPage, int pageSize);

    /**
     * 判断user是否存在
     *
     * @param user user
     * @return 是否存在
     */
    boolean isExisted(User user);
}
