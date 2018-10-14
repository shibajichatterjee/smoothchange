/**
 * 
 */
package com.rest.smoothchange.action.plan.items.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.action.plan.items.entity.ActionPlanItems;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.entity.ImpactAnalysis;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.util.ActionType;
import com.rest.smoothchange.util.EngagementStrategy;
import com.rest.smoothchange.util.LevelOfInfluence;
import com.rest.smoothchange.util.StakeholderType;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ActionPlanItemsMapper extends AbstractMapper<ActionPlanItemsDto , ActionPlanItems>{

	
	@Override
	public ActionPlanItems mapDtoToEntity(ActionPlanItemsDto dto) {
		
		ActionPlanItems actionPlanItems = null;
		if(dto!=null) {
			actionPlanItems = new ActionPlanItems();
			ProjectBackground projectBackground =null;
			actionPlanItems.setId(dto.getId());
			actionPlanItems.setAction(dto.getAction());
			actionPlanItems.setActionType(dto.getActionType());
			actionPlanItems.setResponsible(dto.getResponsible());
			actionPlanItems.setTimeframe(dto.getTimeframe());
			if(dto.getProjectBackground()!=null) {
				projectBackground = new ProjectBackground();
				projectBackground.setId(dto.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange()));
				actionPlanItems.setProjectBackground(projectBackground);
			}						
		}
		return actionPlanItems;
	}

	@Override
	public ActionPlanItemsDto mapEntityToDto(ActionPlanItems bo) {
		
		ActionPlanItemsDto actionPlanItemsDto = null;
		try
		{
		if(bo!=null) {
			actionPlanItemsDto = new ActionPlanItemsDto();
			ProjectBackgroundDto projectBackground =null;
			actionPlanItemsDto.setId(bo.getId());
			if(bo.getActionType()!=null) {
				actionPlanItemsDto.setActionType(bo.getActionType());
			}
			actionPlanItemsDto.setAction(bo.getAction());
			actionPlanItemsDto.setResponsible(bo.getResponsible());
			actionPlanItemsDto.setTimeframe(bo.getTimeframe());
			if(bo.getProjectBackground()!=null) {
				projectBackground = new ProjectBackgroundDto();
				projectBackground.setId(bo.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				actionPlanItemsDto.setProjectBackground(projectBackground);
			}			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  return actionPlanItemsDto;
	
	}
	
}
