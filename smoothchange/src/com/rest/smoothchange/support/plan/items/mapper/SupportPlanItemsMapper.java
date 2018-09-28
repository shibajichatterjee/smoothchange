/**
 * 
 */
package com.rest.smoothchange.support.plan.items.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.support.plan.dto.SupportPlanDto;
import com.rest.smoothchange.support.plan.entity.SupportPlan;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;
import com.rest.smoothchange.support.plan.items.entity.SupportPlanItems;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class SupportPlanItemsMapper extends AbstractMapper<SupportPlanItemsDto , SupportPlanItems>{

	@Override
	public SupportPlanItems mapDtoToEntity(SupportPlanItemsDto dto) {
		SupportPlanItems supportPlanItems = null;
		   if(dto!=null) { 
			   supportPlanItems = new SupportPlanItems();
			   supportPlanItems.setComments(dto.getComments());
			   supportPlanItems.setDuration(dto.getDuration());
			   supportPlanItems.setId(dto.getId());
			   supportPlanItems.setPersonResponsible(dto.getPersonResponsible());
			   supportPlanItems.setSupportActivity(dto.getSupportActivity());
			   supportPlanItems.setSupportedStackHolderStatus(dto.getSupportedStackHolderStatus());
			   SupportPlan supportPlan = null;
			   if(dto.getSupportPlan()!=null) {
				   supportPlan = new SupportPlan();
				   supportPlan.setId(dto.getSupportPlan().getId());
				   ChangeManagementPlan changeManagementPlan = null;
				   if(dto.getSupportPlan().getChangeManagementPlan()!=null) {
					   changeManagementPlan = new ChangeManagementPlan();
					   changeManagementPlan.setId(dto.getSupportPlan().getChangeManagementPlan().getId());
					   ProjectBackground projectBackground = null;
						if(dto.getSupportPlan().getChangeManagementPlan().getProjectBackground()!=null) {
							projectBackground = new ProjectBackground();
							projectBackground.setId(dto.getSupportPlan().getChangeManagementPlan().getProjectBackground().getId());
							projectBackground.setOtherTypeOfChange(dto.getSupportPlan().getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(dto.getSupportPlan().getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
							projectBackground.setProjectDescription(dto.getSupportPlan().getChangeManagementPlan().getProjectBackground().getProjectDescription());
							projectBackground.setProjectName(dto.getSupportPlan().getChangeManagementPlan().getProjectBackground().getProjectName());
							projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getSupportPlan().getChangeManagementPlan().getProjectBackground().getTypeOfChange()));
							changeManagementPlan.setProjectBackground(projectBackground); 
				      }
				  supportPlan.setChangeManagementPlan(changeManagementPlan);	
			   }
				   supportPlanItems.setSupportPlan(supportPlan);     
			   }
			 }		
		   return supportPlanItems;
	}

	@Override
	public SupportPlanItemsDto mapEntityToDto(SupportPlanItems bo) {
		SupportPlanItemsDto supportPlanItems = null;
		   if(bo!=null) { 
			   supportPlanItems = new SupportPlanItemsDto();
			   supportPlanItems.setComments(bo.getComments());
			   supportPlanItems.setDuration(bo.getDuration());
			   supportPlanItems.setId(bo.getId());
			   supportPlanItems.setPersonResponsible(bo.getPersonResponsible());
			   supportPlanItems.setSupportActivity(bo.getSupportActivity());
			   supportPlanItems.setSupportedStackHolderStatus(bo.getSupportedStackHolderStatus());
			   SupportPlanDto supportPlan = null;
			   if(bo.getSupportPlan()!=null) {
				   supportPlan = new SupportPlanDto();
				   supportPlan.setId(bo.getSupportPlan().getId());
				   ChangeManagementPlanDto changeManagementPlan = null;
				   if(bo.getSupportPlan().getChangeManagementPlan()!=null) {
					   changeManagementPlan = new ChangeManagementPlanDto();
					   changeManagementPlan.setId(bo.getSupportPlan().getChangeManagementPlan().getId());
					   ProjectBackgroundDto projectBackground = null;
						if(bo.getSupportPlan().getChangeManagementPlan().getProjectBackground()!=null) {
							projectBackground = new ProjectBackgroundDto();
							projectBackground.setId(bo.getSupportPlan().getChangeManagementPlan().getProjectBackground().getId());
							projectBackground.setOtherTypeOfChange(bo.getSupportPlan().getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(bo.getSupportPlan().getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
							projectBackground.setProjectDescription(bo.getSupportPlan().getChangeManagementPlan().getProjectBackground().getProjectDescription());
							projectBackground.setProjectName(bo.getSupportPlan().getChangeManagementPlan().getProjectBackground().getProjectName());
							projectBackground.setTypeOfChange(bo.getSupportPlan().getChangeManagementPlan().getProjectBackground().getTypeOfChange().getMessage());
							changeManagementPlan.setProjectBackground(projectBackground);
				      }
				  supportPlan.setChangeManagementPlan(changeManagementPlan);	
			   }
				   supportPlanItems.setSupportPlan(supportPlan);     
			   }
			 }		
		   return supportPlanItems;
	}	
}
