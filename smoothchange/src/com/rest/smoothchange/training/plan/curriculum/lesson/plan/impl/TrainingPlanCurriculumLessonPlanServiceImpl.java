package com.rest.smoothchange.training.plan.curriculum.lesson.plan.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.dao.TrainingPlanCurriculumLessonPlanDao;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.dto.TrainingPlanCurriculumLessonPlanDto;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.entity.TrainingPlanCurriculumLessonPlan;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.mapper.TrainingPlanCurriculumLessonPlanMapper;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.service.TrainingPlanCurriculumLessonPlanService;
import com.rest.smoothchange.training.plan.equipment.dao.TrainingPlanEquipmentDao;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.entity.TrainingPlanEquipment;
import com.rest.smoothchange.training.plan.equipment.mapper.TrainingPlanEquipmentMapper;
import com.rest.smoothchange.training.plan.equipment.service.TrainingPlanEquipmentService;


@Service
@Transactional
public class TrainingPlanCurriculumLessonPlanServiceImpl extends AbstractService<TrainingPlanCurriculumLessonPlanDao, TrainingPlanCurriculumLessonPlanDto, TrainingPlanCurriculumLessonPlanMapper, TrainingPlanCurriculumLessonPlan>  implements TrainingPlanCurriculumLessonPlanService{


	@Override
	public List<TrainingPlanCurriculumLessonPlanDto> getTrainingPlanCurriculumLessonPlanListByProjectId(long projectId) {
		List<TrainingPlanCurriculumLessonPlanDto> trainingPlanCurriculumLessonPlanDtoList = new ArrayList<>();
		try {
			List<TrainingPlanCurriculumLessonPlan> trainingPlanCurriculumLessonPlanList = dao.getTrainingPlanCurriculumLessonPlanListByProjectId(projectId);
			for (TrainingPlanCurriculumLessonPlan trainingPlanCurriculumLessonPlan : trainingPlanCurriculumLessonPlanList) {
				trainingPlanCurriculumLessonPlanDtoList.add(mapper.mapEntityToDto(trainingPlanCurriculumLessonPlan));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainingPlanCurriculumLessonPlanDtoList;
	}

	
}
