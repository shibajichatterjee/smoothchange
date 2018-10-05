package com.rest.smoothchange.change.readiness.categories.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;


public interface ChangeReadinessCategoriesService extends Service<ChangeReadinessCategoriesDto>{
	
	 ChangeReadinessCategoriesDto getChangeReadinessCategoriesByIdProjectId(ChangeReadinessCategoriesDto changeReadinessCategoriesDto);	
	 List<ChangeReadinessCategoriesDto> getChangeReadinessCategoriesListByProjectId(long projectId);
	
	 ChangeReadinessCategoriesDto getChangeReadinessCategoriesByCodeNameAndProjectId(String categoryName , long projectId);
	

}
