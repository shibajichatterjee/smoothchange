package com.rest.smoothchange.user.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.user.dao.UserDao;
import com.rest.smoothchange.user.entity.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDAO<User> implements UserDao{

	 
}
