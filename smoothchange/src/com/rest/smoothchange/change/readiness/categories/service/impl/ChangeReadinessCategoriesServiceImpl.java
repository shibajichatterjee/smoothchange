package com.rest.smoothchange.change.readiness.categories.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.change.readiness.categories.dao.ChangeReadinessCategoriesDao;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;
import com.rest.smoothchange.change.readiness.categories.mapper.ChangeReadinessCategoriesMapper;
import com.rest.smoothchange.change.readiness.categories.service.ChangeReadinessCategoriesService;


@Service
@Transactional
public class ChangeReadinessCategoriesServiceImpl extends AbstractService<ChangeReadinessCategoriesDao, ChangeReadinessCategoriesDto, ChangeReadinessCategoriesMapper, ChangeReadinessCategories>  implements ChangeReadinessCategoriesService{

	public ChangeReadinessCategoriesDto getChangeReadinessCategoriesByIdProjectId(ChangeReadinessCategoriesDto changeReadinessCategoriesDto) {
		return mapper.mapEntityToDto(dao.getChangeReadinessCategoriesByIdProjectId(changeReadinessCategoriesDto));
	}
	
	public List<ChangeReadinessCategoriesDto> getChangeReadinessCategoriesListByProjectId(long projectId){
		List<ChangeReadinessCategoriesDto> changeReadinessCategoriesList = new ArrayList<>();
		List<ChangeReadinessCategories> changeReadinessCategorieList = dao.getChangeReadinessCategoriesListByProjectId(projectId);
		for(ChangeReadinessCategories ChangeReadinessCategories : changeReadinessCategorieList) {
			changeReadinessCategoriesList.add(mapper.mapEntityToDto(ChangeReadinessCategories));
		}
		return changeReadinessCategoriesList;
	}
	
	public ChangeReadinessCategoriesDto getChangeReadinessCategoriesByCodeNameAndProjectId(String categoryName , long projectId){
		return mapper.mapEntityToDto(dao.getChangeReadinessCategoriesByCodeNameAndProjectId( categoryName ,  projectId));
	}
}
