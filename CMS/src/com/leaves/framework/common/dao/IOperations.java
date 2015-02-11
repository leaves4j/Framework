package com.leaves.framework.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leaves on 2014/8/29.
 * 通用的操作接口
 */
public interface IOperations<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    List<T> findAllByPage(final int currentPage, final int pageSize);

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);

}

