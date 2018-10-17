package com.rest.smoothchange.training.plan.version.history.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.training.plan.version.history.dto.TrainingPlanVersionHistoryDto;


public interface TrainingPlanVersionHistoryService extends Service<TrainingPlanVersionHistoryDto>{
	 
	 List<TrainingPlanVersionHistoryDto>  getTrainingPlanVersionHistoryListByProjectId(long projectId);

}
