package com.rest.smoothchange.readiness.category.items.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;


public interface ReadinessCategoryItemsDao extends DAO<ReadinessCategoryItems>{

 public List<ReadinessCategoryItems> getReadinessCategoryItemsListByCategoryIdProjectId(long categoryId , long projectId);
 
 ReadinessCategoryItems getReadinessCategoryItemsByItemCodeAndCategoryId(long categoryId , String itemCode);
	
}
