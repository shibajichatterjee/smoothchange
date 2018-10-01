/**
 * 
 */
package com.rest.smoothchange.communication.plan.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanDto;
import com.rest.smoothchange.communication.plan.entity.CommunicationPlan;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.util.EngagementStrategy;
import com.rest.smoothchange.util.LevelOfInfluence;
import com.rest.smoothchange.util.StakeholderType;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class CommunicationPlanMapper extends AbstractMapper<CommunicationPlanDto , CommunicationPlan>{

	@Override
	public CommunicationPlan mapDtoToEntity(CommunicationPlanDto dto) {
		
		CommunicationPlan communicationPlan = null;
		if(dto!=null) {
			communicationPlan = new CommunicationPlan();
			ProjectBackground projectBackground =null;
			ProjectStakeholders projectStakeholders = null;
			communicationPlan.setId(dto.getId());
			communicationPlan.setPurposeOfCommunication(dto.getPurposeOfCommunication());
			communicationPlan.setMessage(dto.getMessage());
			communicationPlan.setCommunicationChannel(dto.getCommunicationChannel());
			communicationPlan.setTimingOrDate(dto.getTimingOrDate());
			communicationPlan.setFrequency(dto.getFrequency());
			communicationPlan.setPreparedBy(dto.getPreparedBy());
			communicationPlan.setSentBy(dto.getSentBy());
			communicationPlan.setStatus(dto.getStatus());
			
			if(dto.getProjectBackground()!=null) {
				projectBackground = new ProjectBackground();
				projectBackground.setId(dto.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange()));
				communicationPlan.setProjectBackground(projectBackground);
			}
			
			if(dto.getProjectStakeholders()!=null) {
				projectStakeholders = new ProjectStakeholders();
				projectStakeholders.setEngagementStrategy(EngagementStrategy.getValue(dto.getProjectStakeholders().getEngagementStrategy()));
				projectStakeholders.setId(dto.getProjectStakeholders().getId());
				projectStakeholders.setLevelOfInfluence(LevelOfInfluence.getValue(dto.getProjectStakeholders().getLevelOfInfluence()));
				projectStakeholders.setLocation(dto.getProjectStakeholders().getLocation());
				projectStakeholders.setNumberImpacted(dto.getProjectStakeholders().getNumberImpacted());
				projectStakeholders.setRole(dto.getProjectStakeholders().getRole());
				projectStakeholders.setStakeholderName(dto.getProjectStakeholders().getStakeholderName());
				projectStakeholders.setStakeholderType(StakeholderType.getValue(dto.getProjectStakeholders().getStakeholderType()));
				communicationPlan.setProjectStakeholders(projectStakeholders);
			}
		}
		return communicationPlan;
	}

	@Override
	public CommunicationPlanDto mapEntityToDto(CommunicationPlan bo) {
		CommunicationPlanDto communicationPlan = null;
		if(bo!=null) {
			communicationPlan = new CommunicationPlanDto();
			ProjectBackgroundDto projectBackground =null;
			ProjectStakeholdersDto projectStakeholders = null;
			communicationPlan.setId(bo.getId());
			communicationPlan.setPurposeOfCommunication(bo.getPurposeOfCommunication());
			communicationPlan.setMessage(bo.getMessage());
			communicationPlan.setCommunicationChannel(bo.getCommunicationChannel());
			communicationPlan.setTimingOrDate(bo.getTimingOrDate());
			communicationPlan.setFrequency(bo.getFrequency());
			communicationPlan.setPreparedBy(bo.getPreparedBy());
			communicationPlan.setSentBy(bo.getSentBy());
			communicationPlan.setStatus(bo.getStatus());
			
			if(bo.getProjectBackground()!=null) {
				projectBackground = new ProjectBackgroundDto();
				projectBackground.setId(bo.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				communicationPlan.setProjectBackground(projectBackground);
			}
			
			if(bo.getProjectStakeholders()!=null) {
				projectStakeholders = new ProjectStakeholdersDto();
				projectStakeholders.setEngagementStrategy(bo.getProjectStakeholders().getEngagementStrategy().getNumVal());
				projectStakeholders.setId(bo.getProjectStakeholders().getId());
				projectStakeholders.setLevelOfInfluence(bo.getProjectStakeholders().getLevelOfInfluence().getNumVal());
				projectStakeholders.setLocation(bo.getProjectStakeholders().getLocation());
				projectStakeholders.setNumberImpacted(bo.getProjectStakeholders().getNumberImpacted());
				projectStakeholders.setRole(bo.getProjectStakeholders().getRole());
				projectStakeholders.setStakeholderName(bo.getProjectStakeholders().getStakeholderName());
				projectStakeholders.setStakeholderType(bo.getProjectStakeholders().getStakeholderType().getType());
				communicationPlan.setProjectStakeholders(projectStakeholders);
			}
		}
		return communicationPlan;
	}

	
	
	
	
}
