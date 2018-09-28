package com.rest.smoothchange.user.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.user.dao.UserDao;
import com.rest.smoothchange.user.dto.UserDto;
import com.rest.smoothchange.user.entity.User;
import com.rest.smoothchange.user.mapper.UserMapper;
import com.rest.smoothchange.user.service.UserService;


@Service
@Transactional
public class UserServiceImpl extends AbstractService<UserDao, UserDto, UserMapper, User>  implements UserService{

	
}
