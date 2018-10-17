package com.rest.smoothchange.training.plan.schedule.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.training.plan.schedule.dao.TrainingPlanScheduleDao;
import com.rest.smoothchange.training.plan.schedule.entity.TrainingPlanSchedule;

@Repository
@Transactional
public class TrainingPlanScheduleDaoImpl extends AbstractDAO< TrainingPlanSchedule> implements  TrainingPlanScheduleDao{

	public List<TrainingPlanSchedule> getTrainingPlanScheduleListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(TrainingPlanSchedule.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
}
