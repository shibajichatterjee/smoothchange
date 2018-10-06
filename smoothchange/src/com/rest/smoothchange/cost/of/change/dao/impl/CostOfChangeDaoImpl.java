package com.rest.smoothchange.cost.of.change.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.cost.of.change.dao.CostOfChangeDao;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;

@Repository
@Transactional
public class CostOfChangeDaoImpl extends AbstractDAO<CostOfChange> implements CostOfChangeDao{

	 
	public CostOfChange getCostOfChangeByIdProjectId(CostOfChangeDto costOfChangeDto) {
		Criteria criteria = getSession().createCriteria(CostOfChange.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", costOfChangeDto.getProjectBackground().getId()),Restrictions.eq("id", costOfChangeDto.getId())));
		return (CostOfChange)criteria.uniqueResult();
	}
	
	public List<CostOfChange> getCostOfChangeListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(CostOfChange.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
	
	
	
}
