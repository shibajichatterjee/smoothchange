package com.rest.smoothchange.support.plan.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.support.plan.dao.SupportPlanDao;
import com.rest.smoothchange.support.plan.dto.SupportPlanDto;
import com.rest.smoothchange.support.plan.entity.SupportPlan;
import com.rest.smoothchange.support.plan.mapper.SupportPlanMapper;
import com.rest.smoothchange.support.plan.service.SupportPlanService;


@Service
@Transactional
public class SupportPlanServiceImpl extends AbstractService<SupportPlanDao, SupportPlanDto, SupportPlanMapper, SupportPlan>  implements SupportPlanService{

	
}
