package com.rest.smoothchange.management.plan.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.management.plan.dao.ChangeManagementPlanDao;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.management.plan.mapper.ChangeManagementPlanMapper;
import com.rest.smoothchange.management.plan.service.ChangeManagementPlanService;


@Service
@Transactional
public class ChangeManagementPlanServiceImpl extends AbstractService<ChangeManagementPlanDao, ChangeManagementPlanDto, ChangeManagementPlanMapper, ChangeManagementPlan>  implements ChangeManagementPlanService{

	
}
