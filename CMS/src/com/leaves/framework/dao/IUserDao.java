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
     * 判断user是否存在
     *
     * @param user user
     * @return 是否存在
     */
    boolean isExisted(User user);
}
