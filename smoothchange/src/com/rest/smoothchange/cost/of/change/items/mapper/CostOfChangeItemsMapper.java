/**
 * 
 */
package com.rest.smoothchange.cost.of.change.items.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;
import com.rest.smoothchange.cost.of.change.items.dto.CostOfChangeItemsDto;
import com.rest.smoothchange.cost.of.change.items.entity.CostOfChangeItems;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class CostOfChangeItemsMapper extends AbstractMapper<CostOfChangeItemsDto , CostOfChangeItems>{

	@Override
	public CostOfChangeItems mapDtoToEntity(CostOfChangeItemsDto dto) {
		CostOfChangeItems costOfChangeItems = null;
		   if(dto!=null) { 
			   costOfChangeItems = new CostOfChangeItems();
			   costOfChangeItems.setApprovalStatus(dto.getApprovalStatus());
			   costOfChangeItems.setApprover(dto.getApprover());
			   costOfChangeItems.setChangeActivity(dto.getChangeActivity());
			   costOfChangeItems.setCost(dto.getCost());
			   costOfChangeItems.setId(dto.getId());
			   CostOfChange costOfChange = null;
			    
			   if(dto.getCostOfChange()!=null) {
				   costOfChange = new CostOfChange();				 
				   costOfChange.setId(dto.getCostOfChange().getId());
				   costOfChange.setTotalCost(dto.getCostOfChange().getTotalCost());
				   ChangeManagementPlan changeManagementPlan = null;
				   if(dto.getCostOfChange().getChangeManagementPlan()!=null) {
					   changeManagementPlan = new ChangeManagementPlan();
					   changeManagementPlan.setId(dto.getCostOfChange().getChangeManagementPlan().getId());
					   ProjectBackground projectBackground = null;
						if(dto.getCostOfChange().getChangeManagementPlan().getProjectBackground()!=null) {
							projectBackground = new ProjectBackground();
							projectBackground.setId(dto.getCostOfChange().getChangeManagementPlan().getProjectBackground().getId());
							projectBackground.setOtherTypeOfChange(dto.getCostOfChange().getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(dto.getCostOfChange().getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
							projectBackground.setProjectDescription(dto.getCostOfChange().getChangeManagementPlan().getProjectBackground().getProjectDescription());
							projectBackground.setProjectName(dto.getCostOfChange().getChangeManagementPlan().getProjectBackground().getProjectName());
							projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getCostOfChange().getChangeManagementPlan().getProjectBackground().getTypeOfChange()));
							changeManagementPlan.setProjectBackground(projectBackground);
						}
						costOfChange.setChangeManagementPlan(changeManagementPlan);
				   }				   
				   costOfChangeItems.setCostOfChange(costOfChange);				 		   
			   }
			  
		   }		
		   return costOfChangeItems;
	}

	@Override
	public CostOfChangeItemsDto mapEntityToDto(CostOfChangeItems bo) {
		CostOfChangeItemsDto costOfChangeItems = null;
		   if(bo!=null) { 
			   costOfChangeItems = new CostOfChangeItemsDto();
			   costOfChangeItems.setApprovalStatus(bo.getApprovalStatus());
			   costOfChangeItems.setApprover(bo.getApprover());
			   costOfChangeItems.setChangeActivity(bo.getChangeActivity());
			   costOfChangeItems.setCost(bo.getCost());
			   costOfChangeItems.setId(bo.getId());
			   CostOfChangeDto costOfChange = null;
			    
			   if(bo.getCostOfChange()!=null) {
				   costOfChange = new CostOfChangeDto();				 
				   costOfChange.setId(bo.getCostOfChange().getId());
				   costOfChange.setTotalCost(bo.getCostOfChange().getTotalCost());
				   ChangeManagementPlanDto changeManagementPlan = null;
				   if(bo.getCostOfChange().getChangeManagementPlan()!=null) {
					   changeManagementPlan = new ChangeManagementPlanDto();
					   changeManagementPlan.setId(bo.getCostOfChange().getChangeManagementPlan().getId());
					   ProjectBackgroundDto projectBackground = null;
						if(bo.getCostOfChange().getChangeManagementPlan().getProjectBackground()!=null) {
							projectBackground = new ProjectBackgroundDto();					
							projectBackground.setId(bo.getCostOfChange().getChangeManagementPlan().getProjectBackground().getId());					
							projectBackground.setOtherTypeOfChange(bo.getCostOfChange().getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
							projectBackground.setOwnerOfChange(bo.getCostOfChange().getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
							projectBackground.setProjectDescription(bo.getCostOfChange().getChangeManagementPlan().getProjectBackground().getProjectDescription());
							projectBackground.setProjectName(bo.getCostOfChange().getChangeManagementPlan().getProjectBackground().getProjectName());
							projectBackground.setTypeOfChange(bo.getCostOfChange().getChangeManagementPlan().getProjectBackground().getTypeOfChange().getMessage());
							changeManagementPlan.setProjectBackground(projectBackground);
						}
						costOfChange.setChangeManagementPlan(changeManagementPlan);
				   }				   
				   costOfChangeItems.setCostOfChange(costOfChange);				 		   
			   }
			  
		   }		
		   return costOfChangeItems;
	}	
}
