package com.rest.smoothchange.training.plan.schedule.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.training.plan.schedule.dto.TrainingPlanScheduleDto;


public interface TrainingPlanScheduleService extends Service<TrainingPlanScheduleDto>{
	
	public TrainingPlanScheduleDto getTrainingPlanScheduleByIdProjectId(TrainingPlanScheduleDto trainingPlanScheduleDto);
	public List<TrainingPlanScheduleDto> getTrainingPlanScheduleListByProjectId(long projectId);

}
