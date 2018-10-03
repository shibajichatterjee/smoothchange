package com.rest.smoothchange.action.plan.items.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.action.plan.items.dao.ActionPlanItemsDao;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.action.plan.items.entity.ActionPlanItems;
import com.rest.smoothchange.impact.analysis.dao.ImpactAnalysisDao;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.entity.ImpactAnalysis;

@Repository
@Transactional
public class ActionPlanItemsDaoImpl extends AbstractDAO<ActionPlanItems> implements ActionPlanItemsDao{

	public ActionPlanItems getActionPlanItemsByIdProjectId(ActionPlanItemsDto actionPlanItemsDto) {
		Criteria criteria = getSession().createCriteria(ActionPlanItems.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", actionPlanItemsDto.getProjectBackground().getId()),Restrictions.eq("id", actionPlanItemsDto.getId())));
		return (ActionPlanItems)criteria.uniqueResult();
	}
	
	public List<ActionPlanItems> getActionPlanItemsByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(ActionPlanItems.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
	


	
	
}
