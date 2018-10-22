/**
 * 
 */
package com.rest.smoothchange.training.plan.curriculum.lesson.plan.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.dto.TrainingPlanCurriculumLessonPlanDto;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.entity.TrainingPlanCurriculumLessonPlan;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.entity.TrainingPlanEquipment;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class TrainingPlanCurriculumLessonPlanMapper extends AbstractMapper<TrainingPlanCurriculumLessonPlanDto ,TrainingPlanCurriculumLessonPlan >{

	@Override
	public TrainingPlanCurriculumLessonPlan mapDtoToEntity(TrainingPlanCurriculumLessonPlanDto dto) {
		TrainingPlanCurriculumLessonPlan trainingPlanCurriculumLessonPlan = null;
		   if(dto!=null) { 
			   trainingPlanCurriculumLessonPlan = new TrainingPlanCurriculumLessonPlan();
			   trainingPlanCurriculumLessonPlan.setCurriculumUnitName(dto.getCurriculumUnitName());
			   trainingPlanCurriculumLessonPlan.setCurriculumUnitNo(dto.getCurriculumUnitNo());
			   trainingPlanCurriculumLessonPlan.setDuration(dto.getDuration());
			   trainingPlanCurriculumLessonPlan.setId(dto.getId());
			   trainingPlanCurriculumLessonPlan.setLessonUnitName(dto.getLessonUnitName());
			   trainingPlanCurriculumLessonPlan.setLessonUnitNo(dto.getLessonUnitNo());
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
				trainingPlanCurriculumLessonPlan.setProjectBackground(projectBackground);
			   }
		   }		
		   return trainingPlanCurriculumLessonPlan;
	}

	@Override
	public TrainingPlanCurriculumLessonPlanDto mapEntityToDto(TrainingPlanCurriculumLessonPlan bo) {
		TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto = null;
		   if(bo!=null) {
			   trainingPlanCurriculumLessonPlanDto = new TrainingPlanCurriculumLessonPlanDto();
			   trainingPlanCurriculumLessonPlanDto.setCurriculumUnitName(bo.getCurriculumUnitName());
			   trainingPlanCurriculumLessonPlanDto.setCurriculumUnitNo(bo.getCurriculumUnitNo());
			   trainingPlanCurriculumLessonPlanDto.setDuration(bo.getDuration());
			   trainingPlanCurriculumLessonPlanDto.setId(bo.getId());
			   trainingPlanCurriculumLessonPlanDto.setLessonUnitName(bo.getLessonUnitName());
			   trainingPlanCurriculumLessonPlanDto.setLessonUnitNo(bo.getLessonUnitNo());
			   ProjectBackgroundDto projectBackground = null;
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
				trainingPlanCurriculumLessonPlanDto.setProjectBackground(projectBackground);
			   }
	   }		
	   return trainingPlanCurriculumLessonPlanDto;
	}	
}
