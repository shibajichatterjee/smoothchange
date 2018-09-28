/**
 * 
 */
package com.rest.smoothchange.project.stakeholders.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.util.EngagementStrategy;
import com.rest.smoothchange.util.LevelOfInfluence;
import com.rest.smoothchange.util.StakeholderType;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ProjectStakeholdersMapper extends AbstractMapper<ProjectStakeholdersDto, ProjectStakeholders> {

	@Override
	public ProjectStakeholders mapDtoToEntity(ProjectStakeholdersDto dto) {

		ProjectStakeholders projectStakeholders = null;
		if (dto != null) {
			projectStakeholders = new ProjectStakeholders();
			ProjectBackground projectBackground = null;
			EngagementStrategy engagementStrategy = EngagementStrategy.getValue(dto.getEngagementStrategy());
			projectStakeholders.setEngagementStrategy(engagementStrategy);
			projectStakeholders.setId(dto.getId());
			LevelOfInfluence levelOfInfluence = LevelOfInfluence.getValue(dto.getLevelOfInfluence());
			projectStakeholders.setLevelOfInfluence(levelOfInfluence);
			projectStakeholders.setLocation(dto.getLocation());
			projectStakeholders.setNumberImpacted(dto.getNumberImpacted());
			projectStakeholders.setRole(dto.getRole());
			projectStakeholders.setStakeholderName(dto.getStakeholderName());
			StakeholderType stakeholderType = StakeholderType.getValue(dto.getStakeholderType());

			projectStakeholders.setStakeholderType(stakeholderType);
			if (dto.getProjectBackground() != null) {
				projectBackground = new ProjectBackground();
				projectBackground.setId(dto.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				TypeOfChange type = TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange());
				projectBackground.setTypeOfChange(type);
				projectStakeholders.setProjectBackground(projectBackground);
			}
		}
		return projectStakeholders;
	}

	@Override
	public ProjectStakeholdersDto mapEntityToDto(ProjectStakeholders bo) {
		ProjectStakeholdersDto projectStakeholdersDto = null;
		if (bo != null) {
			projectStakeholdersDto = new ProjectStakeholdersDto();
			ProjectBackgroundDto projectBackground = null;
			projectStakeholdersDto.setEngagementStrategy(bo.getEngagementStrategy().getNumVal());
			projectStakeholdersDto.setId(bo.getId());
			projectStakeholdersDto.setLevelOfInfluence(bo.getLevelOfInfluence().getNumVal());
			projectStakeholdersDto.setLocation(bo.getLocation());
			projectStakeholdersDto.setNumberImpacted(bo.getNumberImpacted());
			projectStakeholdersDto.setRole(bo.getRole());
			projectStakeholdersDto.setStakeholderName(bo.getStakeholderName());
			projectStakeholdersDto.setStakeholderType(bo.getStakeholderType().getType());
			if (bo.getProjectBackground() != null) {
				projectBackground = new ProjectBackgroundDto();
				projectBackground.setId(bo.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				projectStakeholdersDto.setProjectBackground(projectBackground);
			}
		}
		return projectStakeholdersDto;
	}

}
