package com.leaves.framework.common.dao;

/**
 * Created by leaves on 2014/8/29.
 * Hibernate封装方法
 */

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.common.base.Preconditions;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {

    private Class<T> cls;

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    protected final void setClass(final Class<T> classToSet) {
        this.cls = Preconditions.checkNotNull(classToSet);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public final T findOne(final String id) {
        return (T) getCurrentSession().get(cls, id);
    }

    @Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + cls.getName()).list();
    }

    @Override
    public final List<T> findAllByPage(int currentPage, int pageSize) {
        return getCurrentSession()
                .createQuery("from " + cls.getName())
                .setFirstResult((currentPage-1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().save(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public final T createOrUpdate(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final String entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

}