package com.rest.smoothchange.training.plan.roles.responsibilities.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.training.plan.roles.responsibilities.entity.TrainingPlanRolesResponsibilities;
import com.rest.smoothchange.training.plan.version.history.entity.TrainingPlanVersionHistory;


public interface TrainingPlanRolesResponsibilitiesDao extends DAO<TrainingPlanRolesResponsibilities>{
	 
	 List<TrainingPlanRolesResponsibilities>  getTrainingPlanRolesResponsibilitiesListByProjectId(long projectId);
	
}
