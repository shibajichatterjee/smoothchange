package com.rest.smoothchange.training.plan.schedule.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.training.plan.schedule.dto.TrainingPlanScheduleDto;
import com.rest.smoothchange.training.plan.schedule.entity.TrainingPlanSchedule;


public interface TrainingPlanScheduleDao extends DAO<TrainingPlanSchedule>{

	
	public TrainingPlanSchedule getTrainingPlanScheduleByIdProjectId(TrainingPlanScheduleDto trainingPlanScheduleDto);
	public List<TrainingPlanSchedule> getTrainingPlanScheduleListByProjectId(long projectId);
	
}
