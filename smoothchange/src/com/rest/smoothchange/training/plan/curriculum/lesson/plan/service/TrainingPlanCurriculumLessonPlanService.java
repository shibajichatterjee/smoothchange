package com.rest.smoothchange.training.plan.curriculum.lesson.plan.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.dto.TrainingPlanCurriculumLessonPlanDto;


public interface TrainingPlanCurriculumLessonPlanService extends Service<TrainingPlanCurriculumLessonPlanDto>{
	
	public List<TrainingPlanCurriculumLessonPlanDto> getTrainingPlanCurriculumLessonPlanListByProjectId(long projectId);

}
