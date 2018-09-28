package com.rest.framework.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.rest.framework.dao.DAO;

public abstract class AbstractDAO<T extends Object> implements DAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> domainClass;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	private String getDomainClassName() {
		return getDomainClass().getName();
	}

	public Serializable create(T t) {
		return getSession().save(t);
	}

	public void createOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	public T getById(Serializable id) {
		return (T) getSession().get(getDomainClassName(), id);
	}

	@SuppressWarnings("unchecked")
	public T load(Serializable id) {
		return (T) getSession().load(getDomainClassName(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getSession().createQuery("from " + getDomainClassName()).list();
	}

	public Serializable update(T t) {
		return (Serializable) (getSession().merge(t));
	}

	public void delete(T t) {
		Object merged = null;
		try {
			merged = getSession().merge(t);
		} catch (ObjectNotFoundException e) {
			return;
		}
		getSession().delete(merged);
	}

	public void deleteById(Serializable id) {
		delete(load(id));
	}

	public void deleteAll() {
		getSession().createQuery("delete " + getDomainClassName()).executeUpdate();
	}

	public Long count() {
		return (Long) getSession().createQuery("select count(*) from " + getDomainClassName()).uniqueResult();
	}

	public boolean exists(Serializable id) {
		return (getById(id) != null);
	}
}
