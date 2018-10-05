package com.rest.smoothchange.readiness.category.master.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.category.master.dao.ReadinessCategoryMasterDao;
import com.rest.smoothchange.readiness.category.master.entity.ReadinessCategoryMaster;

@Repository
@Transactional
public class ReadinessCategoryMasterDaoImpl extends AbstractDAO<ReadinessCategoryMaster> implements ReadinessCategoryMasterDao{

  public ReadinessCategoryMaster getReadinessCategoryMasterDtoByCategoryName(String categoryName) {
	  Criteria criteria = getSession().createCriteria(ReadinessCategoryMaster.class);
	  criteria.add(Restrictions.eq("changeReadinessMasterCategoryName", categoryName));
	  return (ReadinessCategoryMaster)criteria.uniqueResult();
  }
}
