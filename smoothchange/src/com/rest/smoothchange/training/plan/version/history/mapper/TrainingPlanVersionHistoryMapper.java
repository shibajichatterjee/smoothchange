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
            if(dto.getProjectBackground() !=null){
				    projectBackground = new ProjectBackground();					    
					projectBackground.setId(dto.getProjectBackground().getId());						
					projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
					projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
					projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
					projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
					projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange()));
					trainingPlanVersionHistory.setProjectBackground(projectBackground);
			   }
		}
	  return trainingPlanVersionHistory;
	}

	@Override
	public TrainingPlanVersionHistoryDto mapEntityToDto(TrainingPlanVersionHistory bo) {
		TrainingPlanVersionHistoryDto trainingPlanVersionHistory = null;
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
					trainingPlanVersionHistory.setProjectBackground(projectBackground);					
				 }
			}
         return trainingPlanVersionHistory;
	}	
}
