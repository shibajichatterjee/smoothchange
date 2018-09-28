/**
 * 
 */
package com.rest.smoothchange.action.plan.business.unit.items.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.action.plan.business.unit.items.dto.ActionPlanBusinessUnitItemsDto;
import com.rest.smoothchange.action.plan.business.unit.items.entity.ActionPlanBusinessUnitItems;
import com.rest.smoothchange.action.plan.dto.ActionPlanDto;
import com.rest.smoothchange.action.plan.entity.ActionPlan;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ActionPlanBusinessUnitItemsMapper extends AbstractMapper<ActionPlanBusinessUnitItemsDto , ActionPlanBusinessUnitItems>{

	@Override
	public ActionPlanBusinessUnitItems mapDtoToEntity(ActionPlanBusinessUnitItemsDto dto) {
		ActionPlanBusinessUnitItems actionPlanBusinessUnitItems = null;
		   if(dto!=null) { 
			   actionPlanBusinessUnitItems = new ActionPlanBusinessUnitItems();
			   actionPlanBusinessUnitItems.setAction(dto.getAction());
			   actionPlanBusinessUnitItems.setId(dto.getId());
			   actionPlanBusinessUnitItems.setResponsible(dto.getResponsible());
			   actionPlanBusinessUnitItems.setTimeFrame(dto.getTimeFrame());
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
				   actionPlanBusinessUnitItems.setActionPlan(actionPlan);
			   }
			  
		   }		
		   return actionPlanBusinessUnitItems;
	}

	@Override
	public ActionPlanBusinessUnitItemsDto mapEntityToDto(ActionPlanBusinessUnitItems bo) {
		ActionPlanBusinessUnitItemsDto actionPlanBusinessUnitItemsDto = null;
		   if(bo!=null) { 
			   actionPlanBusinessUnitItemsDto = new ActionPlanBusinessUnitItemsDto();
			   actionPlanBusinessUnitItemsDto.setAction(bo.getAction());
			   actionPlanBusinessUnitItemsDto.setId(bo.getId());
			   actionPlanBusinessUnitItemsDto.setResponsible(bo.getResponsible());
			   actionPlanBusinessUnitItemsDto.setTimeFrame(bo.getTimeFrame());
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
				   actionPlanBusinessUnitItemsDto.setActionPlan(actionPlan);
			   }  
		   }		
		   return actionPlanBusinessUnitItemsDto;
	}	
}
