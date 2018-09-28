/**
 * 
 */
package com.rest.smoothchange.action.plan.training.items.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.action.plan.dto.ActionPlanDto;
import com.rest.smoothchange.action.plan.entity.ActionPlan;
import com.rest.smoothchange.action.plan.training.items.dto.ActionPlanTrainingItemsDto;
import com.rest.smoothchange.action.plan.training.items.entity.ActionPlanTrainingItems;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ActionPlanTrainingItemsMapper extends AbstractMapper<ActionPlanTrainingItemsDto , ActionPlanTrainingItems>{

	@Override
	public ActionPlanTrainingItems mapDtoToEntity(ActionPlanTrainingItemsDto dto) {
		ActionPlanTrainingItems actionPlanTrainingItems = null;
		   if(dto!=null) { 
			   actionPlanTrainingItems = new ActionPlanTrainingItems();
			   actionPlanTrainingItems.setAction(dto.getAction());
			   actionPlanTrainingItems.setId(dto.getId());
			   actionPlanTrainingItems.setResponsible(dto.getResponsible());
			   actionPlanTrainingItems.setTimeFrame(dto.getTimeFrame());
			   ActionPlan actionPlan = null;
			   if(dto.getActionPlan()!=null) {
				   actionPlan = new ActionPlan();
				   actionPlan.setId(dto.getActionPlan().getId());
				   ChangeManagementPlan changeManagementPlan =  null;
				   if(dto.getActionPlan().getChangeManagementPlan()!=null) {
					   changeManagementPlan = new ChangeManagementPlan();
					   changeManagementPlan.setId(dto.getActionPlan().getChangeManagementPlan().getId());
					   ProjectBackground projectBackground = null;
						if(dto.getActionPlan().getChangeManagementPlan().getProjectBackground()!=null) {
							projectBackground = new ProjectBackground();					
							projectBackground.setId(dto.getActionPlan().getChangeManagementPlan().getProjectBackground().getId());
							projectBackground.setOtherTypeOfChange(dto.getActionPlan().getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(dto.getActionPlan().getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
							projectBackground.setProjectDescription(dto.getActionPlan().getChangeManagementPlan().getProjectBackground().getProjectDescription());
							projectBackground.setProjectName(dto.getActionPlan().getChangeManagementPlan().getProjectBackground().getProjectName());
							projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getActionPlan().getChangeManagementPlan().getProjectBackground().getTypeOfChange()));
							changeManagementPlan.setProjectBackground(projectBackground);
						}
						actionPlan.setChangeManagementPlan(changeManagementPlan); 
				   }
				   actionPlanTrainingItems.setActionPlan(actionPlan);
			   }
			  
		   }		
		   return actionPlanTrainingItems;
	}

	@Override
	public ActionPlanTrainingItemsDto mapEntityToDto(ActionPlanTrainingItems bo) {
		ActionPlanTrainingItemsDto actionPlanTrainingItemsDto = null;
		   if(bo!=null) { 
			   actionPlanTrainingItemsDto = new ActionPlanTrainingItemsDto();
			   actionPlanTrainingItemsDto.setAction(bo.getAction());
			   actionPlanTrainingItemsDto.setId(bo.getId());
			   actionPlanTrainingItemsDto.setResponsible(bo.getResponsible());
			   actionPlanTrainingItemsDto.setTimeFrame(bo.getTimeFrame());
			   ActionPlanDto actionPlan = null;
			   if(bo.getActionPlan()!=null) {
				   actionPlan = new ActionPlanDto();
				   actionPlan.setId(bo.getActionPlan().getId());
				   ChangeManagementPlanDto changeManagementPlan =  null;
				   if(bo.getActionPlan().getChangeManagementPlan()!=null) {
					   changeManagementPlan = new ChangeManagementPlanDto();
					   changeManagementPlan.setId(bo.getActionPlan().getChangeManagementPlan().getId());
					   ProjectBackgroundDto projectBackground = null;
						if(bo.getActionPlan().getChangeManagementPlan().getProjectBackground()!=null) {
							projectBackground = new ProjectBackgroundDto();
							projectBackground.setId(bo.getActionPlan().getChangeManagementPlan().getProjectBackground().getId());
							projectBackground.setOtherTypeOfChange(bo.getActionPlan().getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(bo.getActionPlan().getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
							projectBackground.setProjectDescription(bo.getActionPlan().getChangeManagementPlan().getProjectBackground().getProjectDescription());
							projectBackground.setProjectName(bo.getActionPlan().getChangeManagementPlan().getProjectBackground().getProjectName());
							projectBackground.setTypeOfChange(bo.getActionPlan().getChangeManagementPlan().getProjectBackground().getTypeOfChange().getMessage());
							changeManagementPlan.setProjectBackground(projectBackground);
						}
						actionPlan.setChangeManagementPlan(changeManagementPlan); 
				   }
				   actionPlanTrainingItemsDto.setActionPlan(actionPlan);
			   }  
		   }		
		   return actionPlanTrainingItemsDto;
	}	
}
