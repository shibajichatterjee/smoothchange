package com.rest.smoothchange.change.readiness.categories.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;


public interface ChangeReadinessCategoriesService extends Service<ChangeReadinessCategoriesDto>{
	
	public ChangeReadinessCategoriesDto getChangeReadinessCategoriesByIdProjectId(ChangeReadinessCategoriesDto changeReadinessCategoriesDto);	
	public List<ChangeReadinessCategoriesDto> getChangeReadinessCategoriesListByProjectId(long projectId);

}
