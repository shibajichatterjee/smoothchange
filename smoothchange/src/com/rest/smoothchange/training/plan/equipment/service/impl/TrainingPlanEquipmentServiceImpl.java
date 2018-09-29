package com.rest.smoothchange.training.plan.equipment.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.training.plan.equipment.dao.TrainingPlanEquipmentDao;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.entity.TrainingPlanEquipment;
import com.rest.smoothchange.training.plan.equipment.mapper.TrainingPlanEquipmentMapper;
import com.rest.smoothchange.training.plan.equipment.service.TrainingPlanEquipmentService;


@Service
@Transactional
public class TrainingPlanEquipmentServiceImpl extends AbstractService<TrainingPlanEquipmentDao, TrainingPlanEquipmentDto, TrainingPlanEquipmentMapper, TrainingPlanEquipment>  implements TrainingPlanEquipmentService{

	@Override
	public TrainingPlanEquipmentDto getTrainingPlanEquipmentByIdProjectId(
			TrainingPlanEquipmentDto trainingPlanEquipmentDto) {
		return mapper.mapEntityToDto(dao.getTrainingPlanEquipmentByIdProjectId(trainingPlanEquipmentDto));
	}

	@Override
	public List<TrainingPlanEquipmentDto> getTrainingPlanEquipmentListByProjectId(long projectId) {
		List<TrainingPlanEquipmentDto> trainingPlanEquipmentDtoList = new ArrayList<>();
		try {
			List<TrainingPlanEquipment> trainingPlanEquipmentList = dao.getTrainingPlanEquipmentListByProjectId(projectId);
			for (TrainingPlanEquipment trainingPlanEquipment : trainingPlanEquipmentList) {
				trainingPlanEquipmentDtoList.add(mapper.mapEntityToDto(trainingPlanEquipment));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainingPlanEquipmentDtoList;
	}

	
}
