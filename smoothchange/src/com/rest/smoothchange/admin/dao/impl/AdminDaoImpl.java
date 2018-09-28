package com.rest.smoothchange.admin.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.admin.dao.AdminDao;
import com.rest.smoothchange.admin.entity.Admin;

@Repository
@Transactional
public class AdminDaoImpl extends AbstractDAO<Admin> implements AdminDao{

	 
}
