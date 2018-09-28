/**
 * 
 */
package com.rest.smoothchange.management.plan.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ChangeManagementPlanMapper extends AbstractMapper<ChangeManagementPlanDto , ChangeManagementPlan>{

	@Override
	public ChangeManagementPlan mapDtoToEntity(ChangeManagementPlanDto dto) {
		ChangeManagementPlan changeManagementPlan = null;
		   if(dto!=null) { 
			   changeManagementPlan = new ChangeManagementPlan();
			   changeManagementPlan.setId(dto.getId());
			   ProjectBackground projectBackground = null;
				if(dto.getProjectBackground()!=null) {
					projectBackground = new ProjectBackground();
					projectBackground.setId(dto.getProjectBackground().getId());
					projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
					projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
					projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
					projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange()));
					changeManagementPlan.setProjectBackground(projectBackground);
				}
		   }		
		   return changeManagementPlan;
	}

	@Override
	public ChangeManagementPlanDto mapEntityToDto(ChangeManagementPlan bo) {
		ChangeManagementPlanDto changeManagementPlan = null;
		   if(bo!=null) { 
			   changeManagementPlan = new ChangeManagementPlanDto();
			   changeManagementPlan.setId(bo.getId());
			   ProjectBackgroundDto projectBackground = null;
				if(bo.getProjectBackground()!=null) {
					projectBackground = new ProjectBackgroundDto();
					projectBackground.setId(bo.getProjectBackground().getId());
					projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
					projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
					projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
					projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
					changeManagementPlan.setProjectBackground(projectBackground);
				}
		   }		
		   return changeManagementPlan;
	}	
}
