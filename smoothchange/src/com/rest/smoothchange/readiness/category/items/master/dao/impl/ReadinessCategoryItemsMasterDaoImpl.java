package com.rest.smoothchange.readiness.category.items.master.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;
import com.rest.smoothchange.readiness.category.items.master.dao.ReadinessCategoryItemsMasterDao;
import com.rest.smoothchange.readiness.category.items.master.entity.ReadinessCategoryItemsMaster;

@Repository
@Transactional
public class ReadinessCategoryItemsMasterDaoImpl extends AbstractDAO<ReadinessCategoryItemsMaster> implements ReadinessCategoryItemsMasterDao{

	
	public List<ReadinessCategoryItemsMaster> getReadinessCategoryItemsMasterByCategoryMasterId(long categoryMasterId){
		Criteria criteria = getSession().createCriteria(ReadinessCategoryItemsMaster.class);
		criteria.createAlias("readinessCategoryMaster", "readinessCategoryMaster" ,JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("readinessCategoryMaster.id", categoryMasterId));
		return criteria.list();			
	}
		
	 
}
