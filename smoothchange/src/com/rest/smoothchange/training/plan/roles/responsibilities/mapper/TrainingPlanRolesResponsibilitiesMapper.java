/**
 * 
 */
package com.rest.smoothchange.training.plan.roles.responsibilities.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.training.plan.dto.TrainingPlanDto;
import com.rest.smoothchange.training.plan.entity.TrainingPlan;
import com.rest.smoothchange.training.plan.roles.responsibilities.dto.TrainingPlanRolesResponsibilitiesDto;
import com.rest.smoothchange.training.plan.roles.responsibilities.entity.TrainingPlanRolesResponsibilities;
import com.rest.smoothchange.training.plan.version.history.dto.TrainingPlanVersionHistoryDto;
import com.rest.smoothchange.training.plan.version.history.entity.TrainingPlanVersionHistory;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class TrainingPlanRolesResponsibilitiesMapper extends AbstractMapper<TrainingPlanRolesResponsibilitiesDto , TrainingPlanRolesResponsibilities>{

	@Override
	public TrainingPlanRolesResponsibilities mapDtoToEntity(TrainingPlanRolesResponsibilitiesDto dto) {
		TrainingPlanRolesResponsibilities trainingPlanRolesResponsibilities = null;
		ProjectBackground projectBackground = null;
		if(dto!=null) {
			trainingPlanRolesResponsibilities  = new TrainingPlanRolesResponsibilities();
			trainingPlanRolesResponsibilities.setId(dto.getId());
			trainingPlanRolesResponsibilities.setName(dto.getName());
			trainingPlanRolesResponsibilities.setResponsibility(dto.getResponsibility());
			trainingPlanRolesResponsibilities.setRole(dto.getRole());
            if(dto.getProjectBackground() !=null){
				    projectBackground = new ProjectBackground();					    
					projectBackground.setId(dto.getProjectBackground().getId());						
					projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
					projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
					projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
					projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange()));
					trainingPlanRolesResponsibilities.setProjectBackground(projectBackground);
			   }
		}
	  return trainingPlanRolesResponsibilities;
	}

	@Override
	public TrainingPlanRolesResponsibilitiesDto mapEntityToDto(TrainingPlanRolesResponsibilities bo) {
		TrainingPlanRolesResponsibilitiesDto trainingPlanRolesResponsibilitiesDto = null;
		ProjectBackgroundDto projectBackground = null;
		if(bo!=null) {
			trainingPlanRolesResponsibilitiesDto  = new TrainingPlanRolesResponsibilitiesDto();
			trainingPlanRolesResponsibilitiesDto.setId(bo.getId());
			trainingPlanRolesResponsibilitiesDto.setName(bo.getName());
			trainingPlanRolesResponsibilitiesDto.setResponsibility(bo.getResponsibility());
			trainingPlanRolesResponsibilitiesDto.setRole(bo.getRole());
	          if(bo.getProjectBackground() !=null){
				    projectBackground = new ProjectBackgroundDto();					    
					projectBackground.setId(bo.getProjectBackground().getId());						
					projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
					projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
					projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
					if(bo.getProjectBackground().getTypeOfChange()!=null){
					 projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
	                 }
					trainingPlanRolesResponsibilitiesDto.setProjectBackground(projectBackground);					
				 }
			}
         return trainingPlanRolesResponsibilitiesDto;
	}	
}
