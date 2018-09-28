/**
 * 
 */
package com.rest.smoothchange.cost.of.change.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class CostOfChangeMapper extends AbstractMapper<CostOfChangeDto , CostOfChange>{

	@Override
	public CostOfChange mapDtoToEntity(CostOfChangeDto dto) {
		CostOfChange costOfChange = null;
		   if(dto!=null) { 
			   costOfChange = new CostOfChange();
			   costOfChange.setId(dto.getId());
			   costOfChange.setTotalCost(dto.getTotalCost());
			   ChangeManagementPlan changeManagementPlan = null;
			   if(dto.getChangeManagementPlan()!=null) {
				   changeManagementPlan = new ChangeManagementPlan();
				   changeManagementPlan.setId(dto.getId());
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
					costOfChange.setChangeManagementPlan(changeManagementPlan);
			   }
		   }		
		   return costOfChange;
	}

	@Override
	public CostOfChangeDto mapEntityToDto(CostOfChange bo) {
		CostOfChangeDto costOfChange = null;
		   if(bo!=null) { 
			   costOfChange = new CostOfChangeDto();
			   costOfChange.setId(bo.getId());
			   costOfChange.setTotalCost(bo.getTotalCost());
			   ChangeManagementPlanDto changeManagementPlan = null;
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
					costOfChange.setChangeManagementPlan(changeManagementPlan);
			   }
		   }		
		   return costOfChange;
	}	
}
