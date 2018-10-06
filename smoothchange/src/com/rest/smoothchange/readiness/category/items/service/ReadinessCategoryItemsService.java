package com.rest.smoothchange.readiness.category.items.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;


public interface ReadinessCategoryItemsService extends Service<ReadinessCategoryItemsDto>{
	
	 List<ReadinessCategoryItemsDto> getReadinessCategoryItemsListByCategoryIdProjectId(long categoryId , long projectId);
     
	 ReadinessCategoryItemsDto getReadinessCategoryItemsByItemCodeAndCategoryId(long categoryId , String itemCode);
	
	
}
