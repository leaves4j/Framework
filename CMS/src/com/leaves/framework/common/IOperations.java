package com.leaves.framework.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leaves on 2014/8/29.
 * 通用的操作接口
 */
public interface IOperations<T extends Serializable> {
    /**
     * 查询单个
     *
     * @param id id
     * @return T
     */
    T findOne(final String id);

    /**
     * 查询列表
     *
     * @return List
     */
    List<T> findAll();

    /**
     * 分页查询列表
     *
     * @param currentPage 当前页
     * @param pageSize    分页大小
     * @return List
     */
    List<T> findAllByPage(final int currentPage, final int pageSize);

    /**
     * 根据实体对象新增一个
     *
     * @param entity 实体对象
     */
    void create(final T entity);

    /**
     * 更新
     *
     * @param entity 实体对象
     * @return 实体对象
     */
    T update(final T entity);

    /**
     * 新增或更新（id为null新增，不为null更新）
     *
     * @param entity 实体对象
     * @return 实体对象
     */
    T createOrUpdate(T entity);

    /**
     * 删除
     *
     * @param entity 实体对象
     */
    void delete(final T entity);

    /**
     * 根据id删除
     *
     * @param entityId id
     */
    void deleteById(final String entityId);

}

