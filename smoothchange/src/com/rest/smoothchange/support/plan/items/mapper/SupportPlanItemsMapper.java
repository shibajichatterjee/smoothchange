/**
 * 
 */
package com.rest.smoothchange.support.plan.items.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;
import com.rest.smoothchange.support.plan.items.entity.SupportPlanItems;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class SupportPlanItemsMapper extends AbstractMapper<SupportPlanItemsDto , SupportPlanItems>{

	@Override
	public SupportPlanItems mapDtoToEntity(SupportPlanItemsDto dto) {
		SupportPlanItems supportPlanItems = null;
		ProjectBackground projectBackground = null;
		   if(dto!=null) { 
			   supportPlanItems = new SupportPlanItems();
			   supportPlanItems.setComments(dto.getComments());
			   supportPlanItems.setDuration(dto.getDuration());
			   supportPlanItems.setId(dto.getId());
			   supportPlanItems.setPersonResponsible(dto.getPersonResponsible());
			   supportPlanItems.setSupportActivity(dto.getSupportActivity());
			   supportPlanItems.setSupportedStackHolderStatus(dto.getSupportedStackHolderStatus());
			   if(dto.getProjectBackgroundDto()!=null) {
				   projectBackground = new ProjectBackground();
				   projectBackground.setId(dto.getProjectBackgroundDto().getId());
				   projectBackground.setOtherTypeOfChange(dto.getProjectBackgroundDto().getOtherTypeOfChange());
				   projectBackground.setOwnerOfChange(dto.getProjectBackgroundDto().getOwnerOfChange());
				   projectBackground.setProjectDescription(dto.getProjectBackgroundDto().getProjectDescription());
				   projectBackground.setProjectName(dto.getProjectBackgroundDto().getProjectName());
				   TypeOfChange type=TypeOfChange.getValue(dto.getProjectBackgroundDto().getTypeOfChange());
				   projectBackground.setTypeOfChange(type);
				   projectBackground.setContactPerson(dto.getProjectBackgroundDto().getContactPerson());
				   supportPlanItems.setProjectBackground(projectBackground);
			   }
			 }		
		   return supportPlanItems;
	}

	@Override
	public SupportPlanItemsDto mapEntityToDto(SupportPlanItems bo) {
		SupportPlanItemsDto supportPlanItems = null;
		ProjectBackgroundDto projectBackground = null;
		   if(bo!=null) { 
			   supportPlanItems = new SupportPlanItemsDto();
			   supportPlanItems.setComments(bo.getComments());
			   supportPlanItems.setDuration(bo.getDuration());
			   supportPlanItems.setId(bo.getId());
			   supportPlanItems.setPersonResponsible(bo.getPersonResponsible());
			   supportPlanItems.setSupportActivity(bo.getSupportActivity());
			   supportPlanItems.setSupportedStackHolderStatus(bo.getSupportedStackHolderStatus());
			   if(bo.getProjectBackground()!=null) {
				   projectBackground = new ProjectBackgroundDto();
				   projectBackground.setId(bo.getProjectBackground().getId());
				   projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				   projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				   projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				   projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				   projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				   projectBackground.setContactPerson(bo.getProjectBackground().getContactPerson());
				   supportPlanItems.setProjectBackgroundDto(projectBackground);
			   }
			 }		
		   return supportPlanItems;
	}	
}
