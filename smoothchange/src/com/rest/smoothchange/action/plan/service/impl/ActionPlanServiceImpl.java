package com.rest.smoothchange.action.plan.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.dao.ActionPlanDao;
import com.rest.smoothchange.action.plan.dto.ActionPlanDto;
import com.rest.smoothchange.action.plan.entity.ActionPlan;
import com.rest.smoothchange.action.plan.mapper.ActionPlanMapper;
import com.rest.smoothchange.action.plan.service.ActionPlanService;


@Service
@Transactional
public class ActionPlanServiceImpl extends AbstractService<ActionPlanDao, ActionPlanDto, ActionPlanMapper, ActionPlan>  implements ActionPlanService{

	
}
