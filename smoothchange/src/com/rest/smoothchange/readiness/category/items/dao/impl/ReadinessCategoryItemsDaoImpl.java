package com.rest.smoothchange.readiness.category.items.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.category.items.dao.ReadinessCategoryItemsDao;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;

@Repository
@Transactional
public class ReadinessCategoryItemsDaoImpl extends AbstractDAO<ReadinessCategoryItems> implements ReadinessCategoryItemsDao{

	 
	public List<ReadinessCategoryItems> getReadinessCategoryItemsListByCategoryIdAndProjectId(ReadinessCategoryItemsDto readinessCategoryItemsDto){
		Criteria criteria = getSession().createCriteria(ReadinessCategoryItems.class);
		criteria.createAlias("changeReadinessCategories", "changeReadinessCategories", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("changeReadinessCategories.projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("changeReadinessCategories.id", readinessCategoryItemsDto.getChangeReadinessCategories().getId()));
		criteria.add(Restrictions.eq("projectBackground.id", readinessCategoryItemsDto.getChangeReadinessCategories().getProjectBackgroundDto().getId()));
		return criteria.list();
	}
}
