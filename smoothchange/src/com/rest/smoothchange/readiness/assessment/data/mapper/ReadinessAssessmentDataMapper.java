/**
 * 
 */
package com.rest.smoothchange.readiness.assessment.data.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.readiness.assessment.data.dto.ReadinessAssessmentDataDto;
import com.rest.smoothchange.readiness.assessment.data.entity.ReadinessAssessmentData;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ReadinessAssessmentDataMapper extends AbstractMapper<ReadinessAssessmentDataDto , ReadinessAssessmentData>{

	@Override
	public ReadinessAssessmentData mapDtoToEntity(ReadinessAssessmentDataDto dto) {
		ReadinessAssessmentData readinessAssessmentData = null;
		ReadinessCategoryItems readinessCategoryItems = null;
		 ChangeReadinessCategories changeReadinessCategories = null;
		   if(dto!=null) { 
			   readinessAssessmentData = new ReadinessAssessmentData();
			   readinessAssessmentData.setId(dto.getId());
			   if(dto.getReadinessCategoryItems()!=null) {
				   readinessCategoryItems = new ReadinessCategoryItems();
				   readinessCategoryItems.setId(dto.getReadinessCategoryItems().getId());
				   if(dto.getReadinessCategoryItems().getChangeReadinessCategories()!=null) {
					   ProjectBackground projectBackground = null;
						   changeReadinessCategories = new ChangeReadinessCategories();
						   changeReadinessCategories.setChangeReadinessCategoryName(dto.getReadinessCategoryItems().getChangeReadinessCategories().getChangeReadinessCategoryName());			   
						   if(dto.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto()!=null){
							    projectBackground = new ProjectBackground();
								projectBackground.setId(dto.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getId());
								projectBackground.setOtherTypeOfChange(dto.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getOtherTypeOfChange());
								projectBackground.setOwnerOfChange(dto.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getOwnerOfChange());
								projectBackground.setProjectDescription(dto.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getProjectDescription());
								projectBackground.setProjectName(dto.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getProjectName());
								projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getTypeOfChange()));
								changeReadinessCategories.setProjectBackground(projectBackground);
						}
					   readinessCategoryItems.setChangeReadinessCategories(changeReadinessCategories);
				   }
			   }
			   readinessAssessmentData.setReadinessCategoryItems(readinessCategoryItems);  
		   }		
		   return readinessAssessmentData;
	}

	
	
	@Override
	public ReadinessAssessmentDataDto mapEntityToDto(ReadinessAssessmentData bo) {
	ReadinessAssessmentDataDto readinessAssessmentData = null;
	ReadinessCategoryItemsDto readinessCategoryItems = null;
	ChangeReadinessCategoriesDto changeReadinessCategories = null;
	   if(bo!=null) { 
		   readinessAssessmentData = new ReadinessAssessmentDataDto();
		   readinessAssessmentData.setId(bo.getId());
		   if(bo.getReadinessCategoryItems()!=null) {
			   readinessCategoryItems = new ReadinessCategoryItemsDto();
			   readinessCategoryItems.setId(bo.getReadinessCategoryItems().getId());
			   if(bo.getReadinessCategoryItems().getChangeReadinessCategories()!=null) {
				   ProjectBackgroundDto projectBackground = null;
					   changeReadinessCategories = new ChangeReadinessCategoriesDto();
					   changeReadinessCategories.setChangeReadinessCategoryName(bo.getReadinessCategoryItems().getChangeReadinessCategories().getChangeReadinessCategoryName());			   
					   if(bo.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground()!=null){
						    projectBackground = new ProjectBackgroundDto();						    
							projectBackground.setId(bo.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getId());					
							projectBackground.setOtherTypeOfChange(bo.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(bo.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getOwnerOfChange());
							projectBackground.setProjectDescription(bo.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getProjectDescription());
							projectBackground.setProjectName(bo.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getProjectName());
							projectBackground.setTypeOfChange(bo.getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getTypeOfChange().getMessage());
							changeReadinessCategories.setProjectBackgroundDto(projectBackground);
					}
				   readinessCategoryItems.setChangeReadinessCategories(changeReadinessCategories);
			   }
		   }
		   readinessAssessmentData.setReadinessCategoryItems(readinessCategoryItems);  
	   }		
	   return readinessAssessmentData;
	}	
}
