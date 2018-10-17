package com.rest.smoothchange.training.plan.version.history.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.training.plan.version.history.entity.TrainingPlanVersionHistory;


public interface TrainingPlanVersionHistoryDao extends DAO<TrainingPlanVersionHistory>{
	 
	 List<TrainingPlanVersionHistory>  getTrainingPlanVersionHistoryListByProjectId(long projectId);
	
}
