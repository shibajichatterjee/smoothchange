/**
 * 
 */
package com.rest.smoothchange.readiness.assessment.data.item.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.readiness.assessment.data.dto.ReadinessAssessmentDataDto;
import com.rest.smoothchange.readiness.assessment.data.entity.ReadinessAssessmentData;
import com.rest.smoothchange.readiness.assessment.data.item.dto.ReadinessAssessmentDataItemDto;
import com.rest.smoothchange.readiness.assessment.data.item.entity.ReadinessAssessmentDataItem;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ReadinessAssessmentDataItemMapper extends AbstractMapper<ReadinessAssessmentDataItemDto , ReadinessAssessmentDataItem>{

	@Override
	public ReadinessAssessmentDataItem mapDtoToEntity(ReadinessAssessmentDataItemDto dto) {
		
		
		ReadinessAssessmentDataItem readinessAssessmentDataItem = null;
		ReadinessAssessmentData readinessAssessmentData = null;
		ReadinessCategoryItems readinessCategoryItems = null;
		 ChangeReadinessCategories changeReadinessCategories = null;
		   if(dto!=null) {
			   readinessAssessmentDataItem = new ReadinessAssessmentDataItem();
			   readinessAssessmentDataItem.setChangeReadinessApprover(dto.getChangeReadinessApprover());
			   readinessAssessmentDataItem.setChangeReadinessDate1(dto.getChangeReadinessDate1());
			   readinessAssessmentDataItem.setChangeReadinessDate2(dto.getChangeReadinessDate2());
			   readinessAssessmentDataItem.setChangeReadinessResponsible(dto.getChangeReadinessResponsible());			   
			   if(dto.getReadinessAssessmentDataDto()!=null) {
				   readinessAssessmentData = new ReadinessAssessmentData();
				   readinessAssessmentData.setId(dto.getReadinessAssessmentDataDto().getId());
				   if(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems()!=null) {
					   readinessCategoryItems = new ReadinessCategoryItems();
					   readinessCategoryItems.setId(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getId());
					   readinessCategoryItems.setChangeReadinessCategoryItemCode(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategoryItemCode());
					   readinessCategoryItems.setChangeReadinessCategoryItemDescription(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategoryItemDescription());
					   if(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories()!=null) {
						   ProjectBackground projectBackground = null;
							   changeReadinessCategories = new ChangeReadinessCategories();
							   changeReadinessCategories.setChangeReadinessCategoryName(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories().getChangeReadinessCategoryName());			   
							   if(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto()!=null){
								    projectBackground = new ProjectBackground();
									projectBackground.setId(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getId());
									projectBackground.setOtherTypeOfChange(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getOtherTypeOfChange());
									projectBackground.setOwnerOfChange(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getOwnerOfChange());
									projectBackground.setProjectDescription(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getProjectDescription());
									projectBackground.setProjectName(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getProjectName());
									projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getReadinessAssessmentDataDto().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackgroundDto().getTypeOfChange()));
									changeReadinessCategories.setProjectBackground(projectBackground);
							}
						   readinessCategoryItems.setChangeReadinessCategories(changeReadinessCategories);
					   }
					   readinessAssessmentData.setReadinessCategoryItems(readinessCategoryItems);  
				   }
				   readinessAssessmentDataItem.setReadinessAssessmentData(readinessAssessmentData);
				}
			}		
		   return readinessAssessmentDataItem;
	}

	
	
	@Override
	public ReadinessAssessmentDataItemDto mapEntityToDto(ReadinessAssessmentDataItem bo) {
	
		ReadinessAssessmentDataItemDto readinessAssessmentDataItem = null;
		ReadinessAssessmentDataDto readinessAssessmentData = null;
		ReadinessCategoryItemsDto readinessCategoryItems = null;
		 ChangeReadinessCategoriesDto changeReadinessCategories = null;
		   if(bo!=null) {
			   readinessAssessmentDataItem = new ReadinessAssessmentDataItemDto();
			   readinessAssessmentDataItem.setChangeReadinessApprover(bo.getChangeReadinessApprover());
			   readinessAssessmentDataItem.setChangeReadinessDate1(bo.getChangeReadinessDate1());
			   readinessAssessmentDataItem.setChangeReadinessDate2(bo.getChangeReadinessDate2());
			   readinessAssessmentDataItem.setChangeReadinessResponsible(bo.getChangeReadinessResponsible());			   
			   if(bo.getReadinessAssessmentData()!=null) {
				   readinessAssessmentData = new ReadinessAssessmentDataDto();
				   readinessAssessmentData.setId(bo.getReadinessAssessmentData().getId());
				   if(bo.getReadinessAssessmentData().getReadinessCategoryItems()!=null) {
					   readinessCategoryItems = new ReadinessCategoryItemsDto();
					   readinessCategoryItems.setId(bo.getReadinessAssessmentData().getReadinessCategoryItems().getId());
					   readinessCategoryItems.setChangeReadinessCategoryItemCode(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategoryItemCode());
					   readinessCategoryItems.setChangeReadinessCategoryItemDescription(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategoryItemDescription());
					   if(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories()!=null) {
						   ProjectBackgroundDto projectBackground = null;
							   changeReadinessCategories = new ChangeReadinessCategoriesDto();
							   changeReadinessCategories.setChangeReadinessCategoryName(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getChangeReadinessCategoryName());			   
							   if(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground()!=null){
								    projectBackground = new ProjectBackgroundDto();
									projectBackground.setId(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getId());
									projectBackground.setOtherTypeOfChange(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getOtherTypeOfChange());
									projectBackground.setOwnerOfChange(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getOwnerOfChange());
									projectBackground.setProjectDescription(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getProjectDescription());
									projectBackground.setProjectName(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getProjectName());
									if(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getTypeOfChange()!=null) {
									 projectBackground.setTypeOfChange(bo.getReadinessAssessmentData().getReadinessCategoryItems().getChangeReadinessCategories().getProjectBackground().getTypeOfChange().getMessage());
									}
									
									changeReadinessCategories.setProjectBackgroundDto(projectBackground);
							}
						   readinessCategoryItems.setChangeReadinessCategories(changeReadinessCategories);
					   }
					   readinessAssessmentData.setReadinessCategoryItems(readinessCategoryItems);  
				   }
				   readinessAssessmentDataItem.setReadinessAssessmentDataDto(readinessAssessmentData);
				}
			}		
		   return readinessAssessmentDataItem;
	}	
}
