/**
 * 
 */
package com.rest.smoothchange.cost.of.change.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class CostOfChangeMapper extends AbstractMapper<CostOfChangeDto , CostOfChange>{

	@Override
	public CostOfChange mapDtoToEntity(CostOfChangeDto dto) {
		CostOfChange costOfChange = null;
		ProjectBackground projectBackground = null;
		   if(dto!=null) { 
			   costOfChange = new CostOfChange();
			   costOfChange.setId(dto.getId());
			   costOfChange.setTotalCost(dto.getTotalCost());
			  if(dto.getProjectBackground()!=null) {
				projectBackground = new ProjectBackground();
				projectBackground.setId(dto.getProjectBackground().getId());
			    projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				TypeOfChange type=TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange());
				projectBackground.setTypeOfChange(type);
				projectBackground.setContactPerson(dto.getProjectBackground().getContactPerson());
				costOfChange.setProjectBackground(projectBackground);
			  }		   
		   }		
		   return costOfChange;
	}

	@Override
	public CostOfChangeDto mapEntityToDto(CostOfChange bo) {
		CostOfChangeDto costOfChange = null;
		ProjectBackgroundDto projectBackground = null;
		   if(bo!=null) { 
			   costOfChange = new CostOfChangeDto();
			   costOfChange.setId(bo.getId());
			   costOfChange.setTotalCost(bo.getTotalCost());
			   if(bo.getProjectBackground()!=null) {
				   projectBackground = new ProjectBackgroundDto();
				   projectBackground.setId(bo.getProjectBackground().getId());
				   projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				   projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				   projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				   projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				   if(bo.getProjectBackground().getTypeOfChange()!=null) {
				    projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				   }
				   projectBackground.setContactPerson(bo.getProjectBackground().getContactPerson());
				   costOfChange.setProjectBackground(projectBackground);
			   }			   
		   }		
		   return costOfChange;
	}	
}
