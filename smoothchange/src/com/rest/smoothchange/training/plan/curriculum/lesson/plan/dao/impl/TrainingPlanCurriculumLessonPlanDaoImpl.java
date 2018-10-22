package com.rest.smoothchange.training.plan.curriculum.lesson.plan.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.dao.TrainingPlanCurriculumLessonPlanDao;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.entity.TrainingPlanCurriculumLessonPlan;
import com.rest.smoothchange.training.plan.equipment.dao.TrainingPlanEquipmentDao;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.entity.TrainingPlanEquipment;
import com.rest.smoothchange.training.plan.schedule.entity.TrainingPlanSchedule;

@Repository
@Transactional
public class TrainingPlanCurriculumLessonPlanDaoImpl extends AbstractDAO<TrainingPlanCurriculumLessonPlan> implements  TrainingPlanCurriculumLessonPlanDao{

	
	public List<TrainingPlanCurriculumLessonPlan> getTrainingPlanCurriculumLessonPlanListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(TrainingPlanCurriculumLessonPlan.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
}
