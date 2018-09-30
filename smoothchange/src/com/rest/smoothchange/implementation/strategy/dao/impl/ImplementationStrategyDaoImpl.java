package com.rest.smoothchange.implementation.strategy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.implementation.strategy.dao.ImplementationStrategyDao;
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyDto;
import com.rest.smoothchange.implementation.strategy.entity.ImplementationStrategy;

@Repository
@Transactional
public class ImplementationStrategyDaoImpl extends AbstractDAO<ImplementationStrategy> implements ImplementationStrategyDao{

	public ImplementationStrategy getImplementationStrategyByIdProjectId(ImplementationStrategyDto implementationStrategyDto) {
		Criteria criteria = getSession().createCriteria(ImplementationStrategy.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", implementationStrategyDto.getProjectBackground().getId()),Restrictions.eq("id", implementationStrategyDto.getId())));
		return (ImplementationStrategy)criteria.uniqueResult();
	}
	
	public List<ImplementationStrategy> getImplementationStrategyListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(ImplementationStrategy.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
}
