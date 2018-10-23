package com.rest.smoothchange.training.plan.curriculum.lesson.plan.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.entity.TrainingPlanCurriculumLessonPlan;


public interface TrainingPlanCurriculumLessonPlanDao extends DAO<TrainingPlanCurriculumLessonPlan>{

	
	public List<TrainingPlanCurriculumLessonPlan> getTrainingPlanCurriculumLessonPlanListByProjectId(long projectId);
	
}
