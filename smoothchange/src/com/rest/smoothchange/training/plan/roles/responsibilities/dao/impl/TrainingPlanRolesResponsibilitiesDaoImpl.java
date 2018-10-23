package com.rest.smoothchange.training.plan.roles.responsibilities.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.training.plan.roles.responsibilities.dao.TrainingPlanRolesResponsibilitiesDao;
import com.rest.smoothchange.training.plan.roles.responsibilities.entity.TrainingPlanRolesResponsibilities;
import com.rest.smoothchange.training.plan.version.history.entity.TrainingPlanVersionHistory;

@Repository
@Transactional
public class TrainingPlanRolesResponsibilitiesDaoImpl extends AbstractDAO<TrainingPlanRolesResponsibilities> implements TrainingPlanRolesResponsibilitiesDao{

	
	public List<TrainingPlanRolesResponsibilities>  getTrainingPlanRolesResponsibilitiesListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(TrainingPlanRolesResponsibilities.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
	  
}
