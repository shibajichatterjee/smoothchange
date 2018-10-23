package com.rest.smoothchange.training.plan.roles.responsibilities.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.training.plan.roles.responsibilities.dto.TrainingPlanRolesResponsibilitiesDto;
import com.rest.smoothchange.training.plan.version.history.dto.TrainingPlanVersionHistoryDto;


public interface TrainingPlanRolesResponsibilitiesService extends Service<TrainingPlanRolesResponsibilitiesDto>{
	 
	 List<TrainingPlanRolesResponsibilitiesDto>  getTrainingPlanRolesResponsibilitiesListByProjectId(long projectId);

}
