/**
 * 
 */
package com.rest.smoothchange.action.plan.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.action.plan.dto.ActionPlanDto;
import com.rest.smoothchange.action.plan.entity.ActionPlan;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ActionPlanMapper extends AbstractMapper<ActionPlanDto , ActionPlan>{

	@Override
	public ActionPlan mapDtoToEntity(ActionPlanDto dto) {
		ActionPlan actionPlan = null;
		   if(dto!=null) { 
			   actionPlan = new ActionPlan();
			   actionPlan.setId(dto.getId());
			   ChangeManagementPlan changeManagementPlan =  null;
			   if(dto.getChangeManagementPlan()!=null) {
				   changeManagementPlan = new ChangeManagementPlan();
				   changeManagementPlan.setId(dto.getChangeManagementPlan().getId());
				   ProjectBackground projectBackground = null;
					if(dto.getChangeManagementPlan().getProjectBackground()!=null) {
						projectBackground = new ProjectBackground();
						projectBackground.setId(dto.getChangeManagementPlan().getProjectBackground().getId());
						projectBackground.setOtherTypeOfChange(dto.getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
						projectBackground.setOwnerOfChange(dto.getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
						projectBackground.setProjectDescription(dto.getChangeManagementPlan().getProjectBackground().getProjectDescription());
						projectBackground.setProjectName(dto.getChangeManagementPlan().getProjectBackground().getProjectName());
						projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getChangeManagementPlan().getProjectBackground().getTypeOfChange()));
						changeManagementPlan.setProjectBackground(projectBackground);
					}
					actionPlan.setChangeManagementPlan(changeManagementPlan); 
			   }
		   }		
		   return actionPlan;
	}

	@Override
	public ActionPlanDto mapEntityToDto(ActionPlan bo) {
		ActionPlanDto actionPlan = null;
		   if(bo!=null) { 
			   actionPlan = new ActionPlanDto();
			   actionPlan.setId(bo.getId());
			   ChangeManagementPlanDto changeManagementPlan =  null;
			   if(bo.getChangeManagementPlan()!=null) {
				   changeManagementPlan = new ChangeManagementPlanDto();
				   changeManagementPlan.setId(bo.getChangeManagementPlan().getId());
				   ProjectBackgroundDto projectBackground = null;
					if(bo.getChangeManagementPlan().getProjectBackground()!=null) {
						projectBackground = new ProjectBackgroundDto();
						projectBackground.setId(bo.getChangeManagementPlan().getProjectBackground().getId());
						projectBackground.setOtherTypeOfChange(bo.getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
						projectBackground.setOwnerOfChange(bo.getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
						projectBackground.setProjectDescription(bo.getChangeManagementPlan().getProjectBackground().getProjectDescription());
						projectBackground.setProjectName(bo.getChangeManagementPlan().getProjectBackground().getProjectName());
						projectBackground.setTypeOfChange(bo.getChangeManagementPlan().getProjectBackground().getTypeOfChange().getMessage());
						changeManagementPlan.setProjectBackground(projectBackground);
					}
					actionPlan.setChangeManagementPlan(changeManagementPlan); 
			   }
		   }		
		   return actionPlan;
	}	
}
