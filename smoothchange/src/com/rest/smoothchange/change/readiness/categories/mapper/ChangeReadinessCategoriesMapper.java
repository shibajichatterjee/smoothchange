/**
 * 
 */
package com.rest.smoothchange.change.readiness.categories.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ChangeReadinessCategoriesMapper extends AbstractMapper<ChangeReadinessCategoriesDto , ChangeReadinessCategories>{

	@Override
	public ChangeReadinessCategories mapDtoToEntity(ChangeReadinessCategoriesDto dto) {
		ChangeReadinessCategories changeReadinessCategories = null;
		ProjectBackground projectBackground = null;
		   if(dto!=null) { 
			   changeReadinessCategories = new ChangeReadinessCategories();
			   changeReadinessCategories.setChangeReadinessCategoryName(dto.getChangeReadinessCategoryName());
			   changeReadinessCategories.setId(dto.getId());
			   if(dto.getProjectBackgroundDto()!=null){
				    projectBackground = new ProjectBackground();
					projectBackground.setId(dto.getProjectBackgroundDto().getId());
					projectBackground.setOtherTypeOfChange(dto.getProjectBackgroundDto().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(dto.getProjectBackgroundDto().getOwnerOfChange());
					projectBackground.setProjectDescription(dto.getProjectBackgroundDto().getProjectDescription());
					projectBackground.setProjectName(dto.getProjectBackgroundDto().getProjectName());
					projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackgroundDto().getTypeOfChange()));
					changeReadinessCategories.setProjectBackground(projectBackground);
			   }	   
		   }		
		   return changeReadinessCategories;
	}

	@Override
	public ChangeReadinessCategoriesDto mapEntityToDto(ChangeReadinessCategories bo) {
		ChangeReadinessCategoriesDto changeReadinessCategories = null;
		ProjectBackgroundDto projectBackground = null;
		   if(bo!=null) { 
			   changeReadinessCategories = new ChangeReadinessCategoriesDto();
			   changeReadinessCategories.setChangeReadinessCategoryName(bo.getChangeReadinessCategoryName());
			   changeReadinessCategories.setId(bo.getId());
			   if(bo.getProjectBackground()!=null){
				    projectBackground = new ProjectBackgroundDto();
					projectBackground.setId(bo.getProjectBackground().getId());
					projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
					projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
					projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
					projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
					changeReadinessCategories.setProjectBackgroundDto(projectBackground);			   
					}	   
		   }		
		   return changeReadinessCategories;
	}	
}
