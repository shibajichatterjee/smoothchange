package com.rest.framework.service;

import java.io.Serializable;
import java.util.List;

public interface Service<T extends Object> {
	

	Serializable create(T t);
	void createOrUpdate(T t);
	T getById(Serializable id);
	T load(Serializable id);
	List<T> getAll();
	Serializable update(T t);
	void delete(T t);
	void deleteById(Serializable id);
	void deleteAll();
	Long count();
	boolean exists(Serializable id);

}
