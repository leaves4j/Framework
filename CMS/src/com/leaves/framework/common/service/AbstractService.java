package com.leaves.framework.common.service;

import com.leaves.framework.common.IOperations;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leaves on 2014/8/30.
 */
@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

    protected abstract IOperations<T> getDao();

    @Override
    public T findOne(final String id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(String entityId) {
        getDao().deleteById(entityId);
    }

}
