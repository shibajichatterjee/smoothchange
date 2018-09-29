package com.rest.smoothchange.training.plan.equipment.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;


public interface TrainingPlanEquipmentService extends Service<TrainingPlanEquipmentDto>{
	
	public TrainingPlanEquipmentDto getTrainingPlanEquipmentByIdProjectId(TrainingPlanEquipmentDto trainingPlanEquipmentDto);
	public List<TrainingPlanEquipmentDto> getTrainingPlanEquipmentListByProjectId(long projectId);

}
