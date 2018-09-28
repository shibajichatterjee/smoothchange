package com.rest.smoothchange.admin.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.admin.dao.AdminDao;
import com.rest.smoothchange.admin.dto.AdminDto;
import com.rest.smoothchange.admin.entity.Admin;
import com.rest.smoothchange.admin.mapper.AdminMapper;
import com.rest.smoothchange.admin.service.AdminService;


@Service
@Transactional
public class AdminServiceImpl extends AbstractService<AdminDao, AdminDto, AdminMapper, Admin>  implements AdminService{

	
}
