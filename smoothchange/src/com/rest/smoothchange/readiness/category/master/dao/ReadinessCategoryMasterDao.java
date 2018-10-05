package com.rest.smoothchange.readiness.category.master.dao;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.readiness.category.master.entity.ReadinessCategoryMaster;


public interface ReadinessCategoryMasterDao extends DAO<ReadinessCategoryMaster>{

	
	ReadinessCategoryMaster getReadinessCategoryMasterDtoByCategoryName(String categoryName);
	
}
