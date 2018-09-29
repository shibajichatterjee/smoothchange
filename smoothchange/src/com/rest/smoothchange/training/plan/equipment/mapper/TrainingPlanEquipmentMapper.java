/**
 * 
 */
package com.rest.smoothchange.training.plan.equipment.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.entity.TrainingPlanEquipment;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class TrainingPlanEquipmentMapper extends AbstractMapper<TrainingPlanEquipmentDto ,TrainingPlanEquipment >{

	@Override
	public TrainingPlanEquipment mapDtoToEntity(TrainingPlanEquipmentDto dto) {
		TrainingPlanEquipment trainingPlanEquipment = null;
		   if(dto!=null) { 
			   trainingPlanEquipment = new TrainingPlanEquipment();
			   trainingPlanEquipment.setDateRequired(dto.getDateRequired());
			   trainingPlanEquipment.setEquipmentType(dto.getEquipmentType());
			   trainingPlanEquipment.setId(dto.getId());
			   trainingPlanEquipment.setNumberRequired(dto.getNumberRequired());
			   ProjectBackground projectBackground = null;
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
				trainingPlanEquipment.setProjectBackground(projectBackground);
			   }
		   }		
		   return trainingPlanEquipment;
	}

	@Override
	public TrainingPlanEquipmentDto mapEntityToDto(TrainingPlanEquipment bo) {
		TrainingPlanEquipmentDto trainingPlanEquipmentDto = null;
		   if(bo!=null) { 
			   trainingPlanEquipmentDto = new TrainingPlanEquipmentDto();
			   trainingPlanEquipmentDto.setDateRequired(bo.getDateRequired());
			   trainingPlanEquipmentDto.setEquipmentType(bo.getEquipmentType());
			   trainingPlanEquipmentDto.setId(bo.getId());
			   trainingPlanEquipmentDto.setNumberRequired(bo.getNumberRequired());
			   ProjectBackgroundDto projectBackground = null;
			   if(bo.getProjectBackground()!=null) {
				projectBackground = new ProjectBackgroundDto();
				projectBackground.setId(bo.getProjectBackground().getId());
			    projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
			    projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				projectBackground.setContactPerson(bo.getProjectBackground().getContactPerson());
				trainingPlanEquipmentDto.setProjectBackground(projectBackground);
			   }
		   }		
		   return trainingPlanEquipmentDto;
	}	
}
