package com.rest.smoothchange.training.plan.schedule.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.training.plan.schedule.dao.TrainingPlanScheduleDao;
import com.rest.smoothchange.training.plan.schedule.dto.TrainingPlanScheduleDto;
import com.rest.smoothchange.training.plan.schedule.entity.TrainingPlanSchedule;
import com.rest.smoothchange.training.plan.schedule.mapper.TrainingPlanScheduleMapper;
import com.rest.smoothchange.training.plan.schedule.service.TrainingPlanScheduleService;


@Service
@Transactional
public class TrainingPlanScheduleServiceImpl extends AbstractService<TrainingPlanScheduleDao, TrainingPlanScheduleDto, TrainingPlanScheduleMapper, TrainingPlanSchedule>  implements TrainingPlanScheduleService{

	@Override
	public List<TrainingPlanScheduleDto> getTrainingPlanScheduleListByProjectId(long projectId) {
		List<TrainingPlanScheduleDto> trainingPlanScheduleDtoList = new ArrayList<>();
		try {
			List<TrainingPlanSchedule> trainingPlanScheduleList = dao.getTrainingPlanScheduleListByProjectId(projectId);
			for (TrainingPlanSchedule trainingPlanSchedule : trainingPlanScheduleList) {
				trainingPlanScheduleDtoList.add(mapper.mapEntityToDto(trainingPlanSchedule));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainingPlanScheduleDtoList;
	}

	
}
