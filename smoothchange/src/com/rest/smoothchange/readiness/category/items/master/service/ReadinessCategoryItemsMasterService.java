package com.rest.smoothchange.readiness.category.items.master.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.readiness.category.items.master.dto.ReadinessCategoryItemsMasterDto;


public interface ReadinessCategoryItemsMasterService extends Service<ReadinessCategoryItemsMasterDto>{
	
   List<ReadinessCategoryItemsMasterDto> getReadinessCategoryItemsMasterByCategoryMasterId(long categoryId);

}
