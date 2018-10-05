package com.rest.smoothchange.change.readiness.categories.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.change.readiness.categories.dao.ChangeReadinessCategoriesDao;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;

@Repository
@Transactional
public class ChangeReadinessCategoriesDaoImpl extends AbstractDAO<ChangeReadinessCategories> implements ChangeReadinessCategoriesDao{

	public ChangeReadinessCategories getChangeReadinessCategoriesByIdProjectId(ChangeReadinessCategoriesDto changeReadinessCategoriesDto) {
		Criteria criteria = getSession().createCriteria(ChangeReadinessCategories.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", changeReadinessCategoriesDto.getProjectBackgroundDto().getId()),Restrictions.eq("id", changeReadinessCategoriesDto.getId())));
		return (ChangeReadinessCategories)criteria.uniqueResult();
	}
	
	public List<ChangeReadinessCategories> getChangeReadinessCategoriesListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(ChangeReadinessCategories.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
	
	public ChangeReadinessCategories getChangeReadinessCategoriesByCodeNameAndProjectId(String categoryName , long projectId ) {
		Criteria criteria = getSession().createCriteria(ChangeReadinessCategories.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", projectId),Restrictions.eq("changeReadinessCategoryName", categoryName)));
		return (ChangeReadinessCategories)criteria.uniqueResult();
	}
}
