/**
 * 
 */
package com.rest.smoothchange.impact.analysis.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.entity.ImpactAnalysis;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.util.EngagementStrategy;
import com.rest.smoothchange.util.LevelOfInfluence;
import com.rest.smoothchange.util.StakeholderType;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ImpactAnalysisMapper extends AbstractMapper<ImpactAnalysisDto , ImpactAnalysis>{

	
	@Override
	public ImpactAnalysis mapDtoToEntity(ImpactAnalysisDto dto) {
		
		ImpactAnalysis impactAnalysis = null;
		if(dto!=null) {
			impactAnalysis = new ImpactAnalysis();
			ProjectBackground projectBackground =null;
			ProjectStakeholders projectStakeholders = null;
			impactAnalysis.setId(dto.getId());
			impactAnalysis.setOtherImpactType(dto.getOtherImpactType());
			impactAnalysis.setImpactType(dto.getImpactType());	
			impactAnalysis.setLevelOfImpact(dto.getLevelOfImpact());
			impactAnalysis.setPlannedActivity(dto.getPlannedActivity());
			if(dto.getProjectBackground()!=null) {
				projectBackground = new ProjectBackground();
				projectBackground.setId(dto.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange()));
				impactAnalysis.setProjectBackground(projectBackground);
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
				impactAnalysis.setProjectStakeholders(projectStakeholders);
			}		
		}
		return impactAnalysis;
	}

	@Override
	public ImpactAnalysisDto mapEntityToDto(ImpactAnalysis bo) {
		
		ImpactAnalysisDto impactAnalysis = null;
		if(bo!=null) {
			impactAnalysis = new ImpactAnalysisDto();
			ProjectBackgroundDto projectBackground =null;
			ProjectStakeholdersDto projectStakeholders = null;		
			impactAnalysis.setId(bo.getId());
			impactAnalysis.setOtherImpactType(bo.getOtherImpactType());
			impactAnalysis.setImpactType(bo.getImpactType());
			impactAnalysis.setLevelOfImpact(bo.getLevelOfImpact());
			impactAnalysis.setPlannedActivity(bo.getPlannedActivity());
			if(bo.getProjectBackground()!=null) {
				projectBackground = new ProjectBackgroundDto();
				projectBackground.setId(bo.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				impactAnalysis.setProjectBackground(projectBackground);
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
				impactAnalysis.setProjectStakeholders(projectStakeholders);
			}		
		}
	  return impactAnalysis;
	
	}
	
}
