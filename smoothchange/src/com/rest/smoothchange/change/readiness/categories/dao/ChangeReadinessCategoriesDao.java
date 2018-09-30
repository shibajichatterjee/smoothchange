package com.rest.smoothchange.change.readiness.categories.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;


public interface ChangeReadinessCategoriesDao extends DAO<ChangeReadinessCategories>{

	
	public ChangeReadinessCategories getChangeReadinessCategoriesByIdProjectId(ChangeReadinessCategoriesDto changeReadinessCategoriesDto);	
	public List<ChangeReadinessCategories> getChangeReadinessCategoriesListByProjectId(long projectId);
	
}
