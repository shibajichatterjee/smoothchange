/**
 * 
 */
package com.rest.smoothchange.training.plan.schedule.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.training.plan.schedule.dto.TrainingPlanScheduleDto;
import com.rest.smoothchange.training.plan.schedule.entity.TrainingPlanSchedule;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class TrainingPlanScheduleMapper extends AbstractMapper<TrainingPlanScheduleDto ,TrainingPlanSchedule >{

	@Override
	public TrainingPlanSchedule mapDtoToEntity(TrainingPlanScheduleDto dto) {
		TrainingPlanSchedule trainingPlanSchedule = null;
		   if(dto!=null) { 
			   trainingPlanSchedule = new TrainingPlanSchedule();
			   trainingPlanSchedule.setCurriculumCovered(dto.getCurriculumCovered());
			   trainingPlanSchedule.setDateTime(dto.getDateTime());
			   trainingPlanSchedule.setId(dto.getId());
			   trainingPlanSchedule.setInstructor(dto.getInstructor());
			   trainingPlanSchedule.setLocation(dto.getLocation());
			   trainingPlanSchedule.setSession(dto.getLocation());
			   trainingPlanSchedule.setDuration(dto.getDuration());
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
				trainingPlanSchedule.setProjectBackground(projectBackground);
			   }
		   }		
		   return trainingPlanSchedule;
	}

	@Override
	public TrainingPlanScheduleDto mapEntityToDto(TrainingPlanSchedule bo) {
		TrainingPlanScheduleDto trainingPlanSchedule = null;
		   if(bo!=null) { 
			   trainingPlanSchedule = new TrainingPlanScheduleDto();
			   trainingPlanSchedule.setCurriculumCovered(bo.getCurriculumCovered());
			   trainingPlanSchedule.setDateTime(bo.getDateTime());
			   trainingPlanSchedule.setId(bo.getId());
			   trainingPlanSchedule.setInstructor(bo.getInstructor());
			   trainingPlanSchedule.setLocation(bo.getLocation());
			   trainingPlanSchedule.setSession(bo.getLocation());
			   trainingPlanSchedule.setDuration(bo.getDuration());
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
				trainingPlanSchedule.setProjectBackground(projectBackground);
			   }
		   }		
		   return trainingPlanSchedule;
	}	
}
