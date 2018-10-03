package com.rest.smoothchange.readiness.category.items.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;


public interface ReadinessCategoryItemsService extends Service<ReadinessCategoryItemsDto>{
	
	public List<ReadinessCategoryItemsDto> getReadinessCategoryItemsListByCategoryIdAndProjectId(ReadinessCategoryItemsDto readinessCategoryItemsDto);

}
