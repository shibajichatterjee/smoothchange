/**
 * 
 */
package com.rest.smoothchange.readiness.category.items.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ReadinessCategoryItemsMapper extends AbstractMapper<ReadinessCategoryItemsDto , ReadinessCategoryItems>{

	@Override
	public ReadinessCategoryItems mapDtoToEntity(ReadinessCategoryItemsDto dto) {
		ReadinessCategoryItems readinessCategoryItems = null;
		ChangeReadinessCategories changeReadinessCategories = null;
		   if(dto!=null) { 
			   readinessCategoryItems = new ReadinessCategoryItems();
			   readinessCategoryItems.setId(dto.getId());
			   readinessCategoryItems.setChangeReadinessCategoryItemCode(dto.getChangeReadinessCategoryItemCode());
			   readinessCategoryItems.setChangeReadinessCategoryItemDescription(dto.getChangeReadinessCategoryItemDescription());
			   readinessCategoryItems.setChangeReadinessApprover(dto.getChangeReadinessApprover());
			   readinessCategoryItems.setChangeReadinessDate1(dto.getChangeReadinessDate1());
			   readinessCategoryItems.setChangeReadinessDate2(dto.getChangeReadinessDate2());
			   readinessCategoryItems.setChangeReadinessResponsible(dto.getChangeReadinessResponsible());
			   if(dto.getChangeReadinessCategories()!=null) {
				   ProjectBackground projectBackground = null;
					   changeReadinessCategories = new ChangeReadinessCategories();
					   changeReadinessCategories.setId(dto.getChangeReadinessCategories().getId());
					   changeReadinessCategories.setChangeReadinessCategoryName(dto.getChangeReadinessCategories().getChangeReadinessCategoryName());					 
					   if(dto.getChangeReadinessCategories().getProjectBackgroundDto()!=null){
						    projectBackground = new ProjectBackground();						  
							projectBackground.setId(dto.getChangeReadinessCategories().getProjectBackgroundDto().getId());						
							projectBackground.setOtherTypeOfChange(dto.getChangeReadinessCategories().getProjectBackgroundDto().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(dto.getChangeReadinessCategories().getProjectBackgroundDto().getOwnerOfChange());
							projectBackground.setProjectDescription(dto.getChangeReadinessCategories().getProjectBackgroundDto().getProjectDescription());
							projectBackground.setProjectName(dto.getChangeReadinessCategories().getProjectBackgroundDto().getProjectName());
							projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getChangeReadinessCategories().getProjectBackgroundDto().getTypeOfChange()));
							changeReadinessCategories.setProjectBackground(projectBackground);
					}
				   readinessCategoryItems.setChangeReadinessCategories(changeReadinessCategories);
			   }			   					   
           }		
		return readinessCategoryItems;
	}

	@Override
	public ReadinessCategoryItemsDto mapEntityToDto(ReadinessCategoryItems bo) {
		ReadinessCategoryItemsDto readinessCategoryItemsDto = null;
		ChangeReadinessCategoriesDto changeReadinessCategories = null;
		   if(bo!=null) { 
			   readinessCategoryItemsDto = new ReadinessCategoryItemsDto();
			   readinessCategoryItemsDto.setId(bo.getId());		
			   readinessCategoryItemsDto.setChangeReadinessCategoryItemCode(bo.getChangeReadinessCategoryItemCode());
			   readinessCategoryItemsDto.setChangeReadinessCategoryItemDescription(bo.getChangeReadinessCategoryItemDescription());
			   readinessCategoryItemsDto.setChangeReadinessApprover(bo.getChangeReadinessApprover());
			   readinessCategoryItemsDto.setChangeReadinessDate1(bo.getChangeReadinessDate1());
			   readinessCategoryItemsDto.setChangeReadinessDate2(bo.getChangeReadinessDate2());
			   readinessCategoryItemsDto.setChangeReadinessResponsible(bo.getChangeReadinessResponsible());
			   if(bo.getChangeReadinessCategories()!=null) {
				   ProjectBackgroundDto projectBackground = null;
					   changeReadinessCategories = new ChangeReadinessCategoriesDto();
					   changeReadinessCategories.setId(bo.getChangeReadinessCategories().getId());
					   changeReadinessCategories.setChangeReadinessCategoryName(bo.getChangeReadinessCategories().getChangeReadinessCategoryName());			   
					   if(bo.getChangeReadinessCategories().getProjectBackground()!=null){
						    projectBackground = new ProjectBackgroundDto();						    
							projectBackground.setId(bo.getChangeReadinessCategories().getProjectBackground().getId());							
							projectBackground.setOtherTypeOfChange(bo.getChangeReadinessCategories().getProjectBackground().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(bo.getChangeReadinessCategories().getProjectBackground().getOwnerOfChange());
							projectBackground.setProjectDescription(bo.getChangeReadinessCategories().getProjectBackground().getProjectDescription());
							projectBackground.setProjectName(bo.getChangeReadinessCategories().getProjectBackground().getProjectName());
							if(bo.getChangeReadinessCategories().getProjectBackground().getTypeOfChange()!=null) {
							projectBackground.setTypeOfChange(bo.getChangeReadinessCategories().getProjectBackground().getTypeOfChange().getMessage());
							}
							changeReadinessCategories.setProjectBackgroundDto(projectBackground);
					}
				   readinessCategoryItemsDto.setChangeReadinessCategories(changeReadinessCategories);
			   }			   					   
           }		
		return readinessCategoryItemsDto;
	}	
}
