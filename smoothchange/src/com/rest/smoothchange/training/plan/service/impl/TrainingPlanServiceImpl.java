package com.rest.smoothchange.training.plan.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.training.plan.dao.TrainingPlanDao;
import com.rest.smoothchange.training.plan.dto.TrainingPlanDto;
import com.rest.smoothchange.training.plan.entity.TrainingPlan;
import com.rest.smoothchange.training.plan.mapper.TrainingPlanMapper;
import com.rest.smoothchange.training.plan.service.TrainingPlanService;


@Service
@Transactional
public class TrainingPlanServiceImpl extends AbstractService<TrainingPlanDao, TrainingPlanDto, TrainingPlanMapper, TrainingPlan>  implements TrainingPlanService{

	
}
