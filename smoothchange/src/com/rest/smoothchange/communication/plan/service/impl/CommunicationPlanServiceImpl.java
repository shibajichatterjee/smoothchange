package com.rest.smoothchange.communication.plan.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.communication.plan.dao.CommunicationPlanDao;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanDto;
import com.rest.smoothchange.communication.plan.entity.CommunicationPlan;
import com.rest.smoothchange.communication.plan.mapper.CommunicationPlanMapper;
import com.rest.smoothchange.communication.plan.service.CommunicationPlanService;


@Service
@Transactional
public class CommunicationPlanServiceImpl extends AbstractService<CommunicationPlanDao, CommunicationPlanDto, CommunicationPlanMapper, CommunicationPlan>  implements CommunicationPlanService{

	
}
