/**
 * 
 */
package com.rest.smoothchange.support.plan.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.management.plan.dto.ChangeManagementPlanDto;
import com.rest.smoothchange.management.plan.entity.ChangeManagementPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.support.plan.dto.SupportPlanDto;
import com.rest.smoothchange.support.plan.entity.SupportPlan;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class SupportPlanMapper extends AbstractMapper<SupportPlanDto , SupportPlan>{

	@Override
	public SupportPlan mapDtoToEntity(SupportPlanDto dto) {
		SupportPlan supportPlan = null;
		   if(dto!=null) { 
			   supportPlan = new SupportPlan();
			   supportPlan.setId(dto.getId());
			   ChangeManagementPlan changeManagementPlan = null;
			   if(dto.getChangeManagementPlan()!=null) {
				   changeManagementPlan = new ChangeManagementPlan();
				   changeManagementPlan.setId(dto.getId());
				   ProjectBackground projectBackground = null;
					if(dto.getChangeManagementPlan().getProjectBackground()!=null) {
						projectBackground = new ProjectBackground();
						projectBackground.setId(dto.getChangeManagementPlan().getProjectBackground().getId());
						projectBackground.setOtherTypeOfChange(dto.getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
						projectBackground.setOwnerOfChange(dto.getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
						projectBackground.setProjectDescription(dto.getChangeManagementPlan().getProjectBackground().getProjectDescription());
						projectBackground.setProjectName(dto.getChangeManagementPlan().getProjectBackground().getProjectName());
						projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getChangeManagementPlan().getProjectBackground().getTypeOfChange()));
						changeManagementPlan.setProjectBackground(projectBackground); 
			      }
			  supportPlan.setChangeManagementPlan(changeManagementPlan);	
		     }
		  }
		   return supportPlan;
	}

	@Override
	public SupportPlanDto mapEntityToDto(SupportPlan bo) {
		SupportPlanDto supportPlan = null;
		   if(bo!=null) { 
			   supportPlan = new SupportPlanDto();
			   supportPlan.setId(bo.getId());
			   ChangeManagementPlanDto changeManagementPlan = null;
			   if(bo.getChangeManagementPlan()!=null) {
				   changeManagementPlan = new ChangeManagementPlanDto();
				   changeManagementPlan.setId(bo.getId());
				   ProjectBackgroundDto projectBackground = null;
					if(bo.getChangeManagementPlan().getProjectBackground()!=null) {
						projectBackground = new ProjectBackgroundDto();
						projectBackground.setId(bo.getChangeManagementPlan().getProjectBackground().getId());
						projectBackground.setOtherTypeOfChange(bo.getChangeManagementPlan().getProjectBackground().getOtherTypeOfChange());
						projectBackground.setOwnerOfChange(bo.getChangeManagementPlan().getProjectBackground().getOwnerOfChange());
						projectBackground.setProjectDescription(bo.getChangeManagementPlan().getProjectBackground().getProjectDescription());
						projectBackground.setProjectName(bo.getChangeManagementPlan().getProjectBackground().getProjectName());
						projectBackground.setTypeOfChange(bo.getChangeManagementPlan().getProjectBackground().getTypeOfChange().getMessage());
						changeManagementPlan.setProjectBackground(projectBackground);
			      }
			  supportPlan.setChangeManagementPlan(changeManagementPlan);	
		     }
		  }
		   return supportPlan;
	}	
}
