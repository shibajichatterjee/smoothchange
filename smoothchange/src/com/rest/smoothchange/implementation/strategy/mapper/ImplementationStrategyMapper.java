/**
 * 
 */
package com.rest.smoothchange.implementation.strategy.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyDto;
import com.rest.smoothchange.implementation.strategy.entity.ImplementationStrategy;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ImplementationStrategyMapper extends AbstractMapper<ImplementationStrategyDto , ImplementationStrategy>{

	
	@Override
	public ImplementationStrategy mapDtoToEntity(ImplementationStrategyDto dto) {
		
		ImplementationStrategy implementationStrategy = null;
		if(dto!=null) {
			implementationStrategy = new ImplementationStrategy();
			ProjectBackground projectBackground =null;
			implementationStrategy.setId(dto.getId());
			implementationStrategy.setActivity(dto.getActivity());
			implementationStrategy.setExpectedResult(dto.getExpectedResult());
			implementationStrategy.setStrategicObjective(dto.getStrategicObjective());
			implementationStrategy.setStartDate(dto.getStartDate());
			implementationStrategy.setEndDate(dto.getEndDate());
			implementationStrategy.setLeadContactName(dto.getLeadContactName());
			implementationStrategy.setLeadContactDesignation(dto.getLeadContactDesignation());	
			implementationStrategy.setNoOfRequiredResources(dto.getNoOfRequiredResources());
			if(dto.getProjectBackground()!=null) {
				projectBackground = new ProjectBackground();
				projectBackground.setId(dto.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange()));
				implementationStrategy.setProjectBackground(projectBackground);
			}	
				
		}
		return implementationStrategy;
	}

	@Override
	public ImplementationStrategyDto mapEntityToDto(ImplementationStrategy bo) {
		
		ImplementationStrategyDto implementationStrategy = null;
		if(bo!=null) {
			implementationStrategy = new ImplementationStrategyDto();
			ProjectBackgroundDto projectBackground =null;
			implementationStrategy.setId(bo.getId());
			implementationStrategy.setActivity(bo.getActivity());
			implementationStrategy.setExpectedResult(bo.getExpectedResult());
			implementationStrategy.setStrategicObjective(bo.getStrategicObjective());
			implementationStrategy.setStartDate(bo.getStartDate());
			implementationStrategy.setEndDate(bo.getEndDate());
			implementationStrategy.setLeadContactName(bo.getLeadContactName());
			implementationStrategy.setLeadContactDesignation(bo.getLeadContactDesignation());
			implementationStrategy.setNoOfRequiredResources(bo.getNoOfRequiredResources());
			if(bo.getProjectBackground()!=null) {
				projectBackground = new ProjectBackgroundDto();
				projectBackground.setId(bo.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				implementationStrategy.setProjectBackground(projectBackground);
			}			
		}
		return implementationStrategy;
	
	}
	
}
