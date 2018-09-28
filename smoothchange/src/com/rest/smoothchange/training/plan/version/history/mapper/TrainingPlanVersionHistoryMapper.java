/**
 * 
 */
package com.rest.smoothchange.training.plan.version.history.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.training.plan.dto.TrainingPlanDto;
import com.rest.smoothchange.training.plan.entity.TrainingPlan;
import com.rest.smoothchange.training.plan.version.history.dto.TrainingPlanVersionHistoryDto;
import com.rest.smoothchange.training.plan.version.history.entity.TrainingPlanVersionHistory;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class TrainingPlanVersionHistoryMapper extends AbstractMapper<TrainingPlanVersionHistoryDto , TrainingPlanVersionHistory>{

	@Override
	public TrainingPlanVersionHistory mapDtoToEntity(TrainingPlanVersionHistoryDto dto) {
		TrainingPlanVersionHistory trainingPlanVersionHistory = null;
		TrainingPlan trainingPlan = null;
		ProjectBackground projectBackground = null;
		if(dto!=null) {
			trainingPlanVersionHistory  = new TrainingPlanVersionHistory();
			trainingPlanVersionHistory.setApprovalDate(dto.getApprovalDate());
			trainingPlanVersionHistory.setApprovedBy(dto.getApprovedBy());
			trainingPlanVersionHistory.setAuthor(dto.getAuthor());
			trainingPlanVersionHistory.setId(dto.getId());
			trainingPlanVersionHistory.setReason(dto.getReason());
			trainingPlanVersionHistory.setRevisionDate(dto.getRevisionDate());
			trainingPlanVersionHistory.setVersionNo(dto.getVersionNo());
			if(dto.getTrainingPlan()!=null) {
				trainingPlan = new TrainingPlan();
				trainingPlan.setId(dto.getTrainingPlan().getId());
			     if(dto.getTrainingPlan().getProjectBackgroundDto() !=null){
					    projectBackground = new ProjectBackground();					    
						projectBackground.setId(dto.getTrainingPlan().getProjectBackgroundDto().getId());						
						projectBackground.setOtherTypeOfChange(dto.getTrainingPlan().getProjectBackgroundDto().getOtherTypeOfChange());
						projectBackground.setOwnerOfChange(dto.getTrainingPlan().getProjectBackgroundDto().getOwnerOfChange());
						projectBackground.setProjectDescription(dto.getTrainingPlan().getProjectBackgroundDto().getProjectDescription());
						projectBackground.setProjectName(dto.getTrainingPlan().getProjectBackgroundDto().getProjectName());
						projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getTrainingPlan().getProjectBackgroundDto().getTypeOfChange()));
						trainingPlan.setProjectBackground(projectBackground);
				   }
			}
			trainingPlanVersionHistory.setTrainingPlan(trainingPlan);
		}
		   return trainingPlanVersionHistory;
	}

	@Override
	public TrainingPlanVersionHistoryDto mapEntityToDto(TrainingPlanVersionHistory bo) {
		TrainingPlanVersionHistoryDto trainingPlanVersionHistory = null;
		TrainingPlanDto trainingPlan = null;
		ProjectBackgroundDto projectBackground = null;
		if(bo!=null) {
			trainingPlanVersionHistory  = new TrainingPlanVersionHistoryDto();
			trainingPlanVersionHistory.setApprovalDate(bo.getApprovalDate());
			trainingPlanVersionHistory.setApprovedBy(bo.getApprovedBy());
			trainingPlanVersionHistory.setAuthor(bo.getAuthor());
			trainingPlanVersionHistory.setId(bo.getId());
			trainingPlanVersionHistory.setReason(bo.getReason());
			trainingPlanVersionHistory.setRevisionDate(bo.getRevisionDate());
			trainingPlanVersionHistory.setVersionNo(bo.getVersionNo());
			if(bo.getTrainingPlan()!=null) {
				trainingPlan = new TrainingPlanDto();
				trainingPlan.setId(bo.getTrainingPlan().getId());
			     if(bo.getTrainingPlan().getProjectBackground() !=null){
					    projectBackground = new ProjectBackgroundDto();					    
						projectBackground.setId(bo.getTrainingPlan().getProjectBackground().getId());						
						projectBackground.setOtherTypeOfChange(bo.getTrainingPlan().getProjectBackground().getOtherTypeOfChange());
						projectBackground.setOwnerOfChange(bo.getTrainingPlan().getProjectBackground().getOwnerOfChange());
						projectBackground.setProjectDescription(bo.getTrainingPlan().getProjectBackground().getProjectDescription());
						projectBackground.setProjectName(bo.getTrainingPlan().getProjectBackground().getProjectName());
						projectBackground.setTypeOfChange(bo.getTrainingPlan().getProjectBackground().getTypeOfChange().getMessage());
						trainingPlan.setProjectBackgroundDto(projectBackground);
				   }
			}
			trainingPlanVersionHistory.setTrainingPlan(trainingPlan);
		}
		   return trainingPlanVersionHistory;
	}	
}
