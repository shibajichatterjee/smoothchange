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
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.ApprovalStatus;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class CostOfChangeItemsMapper extends AbstractMapper<CostOfChangeItemsDto , CostOfChangeItems>{

	@Override
	public CostOfChangeItems mapDtoToEntity(CostOfChangeItemsDto dto) {
		CostOfChangeItems costOfChangeItems = null;
		   if(dto!=null) { 
			   costOfChangeItems = new CostOfChangeItems();			   
			   costOfChangeItems.setApprovalStatus(dto.getApprovalStatusObj()); 
			   costOfChangeItems.setApprover(dto.getApprover());
			   costOfChangeItems.setChangeActivity(dto.getChangeActivity());
			   costOfChangeItems.setCost(dto.getCost());
			   costOfChangeItems.setId(dto.getId());
			   CostOfChange costOfChange = null;	    
			   if(dto.getCostOfChange()!=null) {
				   costOfChange = new CostOfChange();				 
				   costOfChange.setId(dto.getCostOfChange().getId());
				   costOfChange.setTotalCost(dto.getCostOfChange().getTotalCost());
				  ProjectBackground projectBackground = null;
				  if(dto.getCostOfChange().getProjectBackground()!=null) {
					  projectBackground = new ProjectBackground();
					  projectBackground.setId(dto.getCostOfChange().getProjectBackground().getId());
					  projectBackground.setOtherTypeOfChange(dto.getCostOfChange().getProjectBackground().getOtherTypeOfChange());
					  projectBackground.setOwnerOfChange(dto.getCostOfChange().getProjectBackground().getOwnerOfChange());
					  projectBackground.setProjectDescription(dto.getCostOfChange().getProjectBackground().getProjectDescription());
					  projectBackground.setProjectName(dto.getCostOfChange().getProjectBackground().getProjectName());
					  TypeOfChange type=TypeOfChange.getValue(dto.getCostOfChange().getProjectBackground().getTypeOfChange());
					  projectBackground.setTypeOfChange(type);
					  projectBackground.setContactPerson(dto.getCostOfChange().getProjectBackground().getContactPerson());
					  projectBackground.setContactPerson(dto.getCostOfChange().getProjectBackground().getContactPerson());
					  costOfChange.setProjectBackground(projectBackground);
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
			   if(bo.getApprovalStatus()!=null) {
				   costOfChangeItems.setApprovalStatusObj(bo.getApprovalStatus());
			   }			
			   costOfChangeItems.setApprover(bo.getApprover());
			   costOfChangeItems.setChangeActivity(bo.getChangeActivity());
			   costOfChangeItems.setCost(bo.getCost());
			   costOfChangeItems.setId(bo.getId());
			   CostOfChangeDto costOfChange = null;
	           if(bo.getCostOfChange()!=null) {
				   costOfChange = new CostOfChangeDto();				 
				   costOfChange.setId(bo.getCostOfChange().getId());
				   costOfChange.setTotalCost(bo.getCostOfChange().getTotalCost());			   
				   costOfChangeItems.setCostOfChange(costOfChange);		
				ProjectBackgroundDto projectBackground = null;
				if(bo.getCostOfChange().getProjectBackground()!=null) {
					 projectBackground = new ProjectBackgroundDto();
					   projectBackground.setId(bo.getCostOfChange().getProjectBackground().getId());
					   projectBackground.setOtherTypeOfChange(bo.getCostOfChange().getProjectBackground().getOtherTypeOfChange());
					   projectBackground.setOwnerOfChange(bo.getCostOfChange().getProjectBackground().getOwnerOfChange());
					   projectBackground.setProjectDescription(bo.getCostOfChange().getProjectBackground().getProjectDescription());
					   projectBackground.setProjectName(bo.getCostOfChange().getProjectBackground().getProjectName());
					   if(bo.getCostOfChange().getProjectBackground().getTypeOfChange()!=null) {
					    projectBackground.setTypeOfChange(bo.getCostOfChange().getProjectBackground().getTypeOfChange().getMessage());
				       }
					   projectBackground.setContactPerson(bo.getCostOfChange().getProjectBackground().getContactPerson());
					   projectBackground.setContactPerson(bo.getCostOfChange().getProjectBackground().getContactPerson());
					   costOfChange.setProjectBackground(projectBackground);
				}	
				costOfChangeItems.setCostOfChange(costOfChange);
			   }			  
		   }		
		   return costOfChangeItems;
	}	
}
