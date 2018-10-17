/**
 * 
 */
package com.rest.smoothchange.training.plan.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.training.plan.dto.TrainingPlanDto;
import com.rest.smoothchange.training.plan.entity.TrainingPlan;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class TrainingPlanMapper extends AbstractMapper<TrainingPlanDto , TrainingPlan>{

	@Override
	public TrainingPlan mapDtoToEntity(TrainingPlanDto dto) {
		TrainingPlan trainingPlan = null;
		ProjectBackground projectBackground = null;
		   if(dto!=null) { 
			   trainingPlan = new TrainingPlan();
			   trainingPlan.setId(dto.getId());
		     if(dto.getProjectBackgroundDto()!=null){
				    projectBackground = new ProjectBackground();
					projectBackground.setId(dto.getProjectBackgroundDto().getId());
					projectBackground.setOtherTypeOfChange(dto.getProjectBackgroundDto().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(dto.getProjectBackgroundDto().getOwnerOfChange());
					projectBackground.setProjectDescription(dto.getProjectBackgroundDto().getProjectDescription());
					projectBackground.setProjectName(dto.getProjectBackgroundDto().getProjectName());
					projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackgroundDto().getTypeOfChange()));
					trainingPlan.setProjectBackground(projectBackground);
			   }	   
		   }		
		   return trainingPlan;
	}

	@Override
	public TrainingPlanDto mapEntityToDto(TrainingPlan bo) {
		TrainingPlanDto trainingPlan = null;
		ProjectBackgroundDto projectBackground = null;
		   if(bo!=null) { 
			   trainingPlan = new TrainingPlanDto();
			   trainingPlan.setId(bo.getId());
		     if(bo.getProjectBackground()!=null){
				    projectBackground = new ProjectBackgroundDto();
					projectBackground.setId(bo.getProjectBackground().getId());
					projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
					projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
					projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
					if(bo.getProjectBackground().getTypeOfChange()!= null) {
					 projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
		            }
					trainingPlan.setProjectBackgroundDto(projectBackground);
			   }	   
		   }		
		   return trainingPlan;
	}	
}
