package com.rest.smoothchange.training.plan.equipment.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.entity.TrainingPlanEquipment;


public interface TrainingPlanEquipmentDao extends DAO<TrainingPlanEquipment>{

	
	public TrainingPlanEquipment getTrainingPlanEquipmentByIdProjectId(TrainingPlanEquipmentDto trainingPlanEquipmentDto);
	public List<TrainingPlanEquipment> getTrainingPlanEquipmentListByProjectId(long projectId);
	
}
