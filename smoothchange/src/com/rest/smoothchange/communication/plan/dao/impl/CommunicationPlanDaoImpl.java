package com.rest.smoothchange.communication.plan.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.communication.plan.dao.CommunicationPlanDao;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanDto;
import com.rest.smoothchange.communication.plan.entity.CommunicationPlan;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.entity.ImpactAnalysis;

@Repository
@Transactional
public class CommunicationPlanDaoImpl extends AbstractDAO<CommunicationPlan> implements CommunicationPlanDao{

	public CommunicationPlan getCommunicationPlanByIdProjectId(CommunicationPlanDto communicationPlanDto) {
		Criteria criteria = getSession().createCriteria(CommunicationPlan.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", communicationPlanDto.getProjectBackground().getId()),Restrictions.eq("id", communicationPlanDto.getId())));
		return (CommunicationPlan)criteria.uniqueResult();
	}
	
	public List<CommunicationPlan> getCommunicationPlanListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(CommunicationPlan.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
}
