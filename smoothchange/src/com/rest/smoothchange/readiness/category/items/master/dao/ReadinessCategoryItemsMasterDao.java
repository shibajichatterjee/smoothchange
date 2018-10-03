package com.rest.smoothchange.readiness.category.items.master.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.readiness.category.items.master.entity.ReadinessCategoryItemsMaster;


public interface ReadinessCategoryItemsMasterDao extends DAO<ReadinessCategoryItemsMaster>{

	List<ReadinessCategoryItemsMaster> getReadinessCategoryItemsMasterByCategoryMasterId(long categoryId);
	
}
