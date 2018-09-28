package com.rest.smoothchange.training.plan.version.history.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.training.plan.version.history.dao.TrainingPlanVersionHistoryDao;
import com.rest.smoothchange.training.plan.version.history.dto.TrainingPlanVersionHistoryDto;
import com.rest.smoothchange.training.plan.version.history.entity.TrainingPlanVersionHistory;
import com.rest.smoothchange.training.plan.version.history.mapper.TrainingPlanVersionHistoryMapper;
import com.rest.smoothchange.training.plan.version.history.service.TrainingPlanVersionHistoryService;


@Service
@Transactional
public class TrainingPlanVersionHistoryServiceImpl extends AbstractService<TrainingPlanVersionHistoryDao, TrainingPlanVersionHistoryDto, TrainingPlanVersionHistoryMapper, TrainingPlanVersionHistory>  implements TrainingPlanVersionHistoryService{

	
}
