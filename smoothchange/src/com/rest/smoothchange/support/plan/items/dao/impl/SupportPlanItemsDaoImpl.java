package com.rest.smoothchange.support.plan.items.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.support.plan.items.dao.SupportPlanItemsDao;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;
import com.rest.smoothchange.support.plan.items.entity.SupportPlanItems;

@Repository
@Transactional
public class SupportPlanItemsDaoImpl extends AbstractDAO<SupportPlanItems> implements SupportPlanItemsDao{

	 
	public SupportPlanItems getSupportPlanItemsByIdProjectId(SupportPlanItemsDto supportPlanItemsDto) {
		Criteria criteria = getSession().createCriteria(SupportPlanItems.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", supportPlanItemsDto.getProjectBackgroundDto().getId()),Restrictions.eq("id", supportPlanItemsDto.getId())));
		return (SupportPlanItems)criteria.uniqueResult();
	}
	
	public List<SupportPlanItems> getSupportPlanItemsListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(SupportPlanItems.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
	
}
