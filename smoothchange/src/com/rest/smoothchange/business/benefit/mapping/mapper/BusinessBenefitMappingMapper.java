/**
 * 
 */
package com.rest.smoothchange.business.benefit.mapping.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;
import com.rest.smoothchange.business.benefit.mapping.entity.BusinessBenefitMapping;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.util.BusinessBenefit;
import com.rest.smoothchange.util.EngagementStrategy;
import com.rest.smoothchange.util.LevelOfInfluence;
import com.rest.smoothchange.util.StakeholderType;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class BusinessBenefitMappingMapper extends AbstractMapper<BusinessBenefitMappingDto , BusinessBenefitMapping>{

	@Override
	public BusinessBenefitMapping mapDtoToEntity(BusinessBenefitMappingDto dto) {
		
		
		BusinessBenefitMapping businessBenefitMapping = null;
		if(dto!=null) {
			businessBenefitMapping = new BusinessBenefitMapping();
			ProjectBackground projectBackground =null;
			ProjectStakeholders projectStakeholders = null;
			businessBenefitMapping.setId(dto.getId());	
			businessBenefitMapping.setBusinessBenefit(BusinessBenefit.getValue(dto.getBusinessBenefit()));		
			businessBenefitMapping.setBusiness_benefit_other(dto.getBusiness_benefit_other());
			
			if(dto.getProjectBackground()!=null) {
				projectBackground = new ProjectBackground();
				projectBackground.setId(dto.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange()));
				businessBenefitMapping.setProjectBackground(projectBackground);
			}	
			if(dto.getProjectStakeholders()!=null) {
				 projectStakeholders = new ProjectStakeholders();
				 ProjectBackground projectBackgroundStackHolder = null;
					EngagementStrategy engagementStrategy = EngagementStrategy.getValue(dto.getProjectStakeholders().getEngagementStrategy());
					projectStakeholders.setEngagementStrategy(engagementStrategy);
					projectStakeholders.setId(dto.getProjectStakeholders().getId());
					LevelOfInfluence levelOfInfluence = LevelOfInfluence.getValue(dto.getProjectStakeholders().getLevelOfInfluence());
					projectStakeholders.setLevelOfInfluence(levelOfInfluence);
					projectStakeholders.setLocation(dto.getProjectStakeholders().getLocation());
					projectStakeholders.setNumberImpacted(dto.getProjectStakeholders().getNumberImpacted());
					projectStakeholders.setRole(dto.getProjectStakeholders().getRole());
					projectStakeholders.setStakeholderName(dto.getProjectStakeholders().getStakeholderName());
					projectStakeholders.setEngagementStrategyOther(dto.getProjectStakeholders().getEngagementStrategyOther());
					StakeholderType stakeholderType = StakeholderType.getValue(dto.getProjectStakeholders().getStakeholderType());
					projectStakeholders.setStakeholderType(stakeholderType);
					if (dto.getProjectBackground() != null) {
						projectBackgroundStackHolder = new ProjectBackground();
						projectBackgroundStackHolder.setId(dto.getProjectStakeholders().getProjectBackground().getId());
						projectBackgroundStackHolder.setOtherTypeOfChange(dto.getProjectStakeholders().getProjectBackground().getOtherTypeOfChange());
						projectBackgroundStackHolder.setOwnerOfChange(dto.getProjectStakeholders().getProjectBackground().getOwnerOfChange());
						projectBackgroundStackHolder.setProjectDescription(dto.getProjectStakeholders().getProjectBackground().getProjectDescription());
						projectBackgroundStackHolder.setProjectName(dto.getProjectStakeholders().getProjectBackground().getProjectName());
						TypeOfChange type = TypeOfChange.getValue(dto.getProjectStakeholders().getProjectBackground().getTypeOfChange());
						projectBackgroundStackHolder.setTypeOfChange(type);
						projectStakeholders.setProjectBackground(projectBackgroundStackHolder);
					}
					businessBenefitMapping.setProjectStakeholders(projectStakeholders);	
			}
		}
		return businessBenefitMapping;
	}

	@Override
	public BusinessBenefitMappingDto mapEntityToDto(BusinessBenefitMapping bo) {
		BusinessBenefitMappingDto businessBenefitMappingDto = null;
		if(bo!=null) {
			businessBenefitMappingDto = new BusinessBenefitMappingDto();
			ProjectBackgroundDto projectBackground =null;
			ProjectStakeholdersDto projectStakeholdersDto=null;
			businessBenefitMappingDto.setId(bo.getId());
			if(bo.getBusinessBenefit()!=null) {
			 businessBenefitMappingDto.setBusinessBenefit(bo.getBusinessBenefit().getValue());
			}
			businessBenefitMappingDto.setBusiness_benefit_other(bo.getBusiness_benefit_other());
			if(bo.getProjectBackground()!=null) {
				projectBackground = new ProjectBackgroundDto();			
				projectBackground.setId(bo.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				businessBenefitMappingDto.setProjectBackground(projectBackground);
			}
			
			if(bo.getProjectStakeholders()!=null) {
				projectStakeholdersDto = new ProjectStakeholdersDto();
				ProjectBackgroundDto projectBackgroundStackHolder = null;
				projectStakeholdersDto.setEngagementStrategy(bo.getProjectStakeholders().getEngagementStrategy().getNumVal());
				projectStakeholdersDto.setId(bo.getProjectStakeholders().getId());
				projectStakeholdersDto.setLevelOfInfluence(bo.getProjectStakeholders().getLevelOfInfluence().getNumVal());
				projectStakeholdersDto.setLocation(bo.getProjectStakeholders().getLocation());
				projectStakeholdersDto.setNumberImpacted(bo.getProjectStakeholders().getNumberImpacted());
				projectStakeholdersDto.setRole(bo.getProjectStakeholders().getRole());
				projectStakeholdersDto.setStakeholderName(bo.getProjectStakeholders().getStakeholderName());
				projectStakeholdersDto.setStakeholderType(bo.getProjectStakeholders().getStakeholderType().getType());
				projectStakeholdersDto.setEngagementStrategyOther(bo.getProjectStakeholders().getEngagementStrategyOther());
				if (bo.getProjectStakeholders().getProjectBackground() != null) {
					projectBackgroundStackHolder = new ProjectBackgroundDto();
					projectBackgroundStackHolder.setId(bo.getProjectStakeholders().getProjectBackground().getId());
					projectBackgroundStackHolder.setOtherTypeOfChange(bo.getProjectStakeholders().getProjectBackground().getOtherTypeOfChange());
					projectBackgroundStackHolder.setOwnerOfChange(bo.getProjectStakeholders().getProjectBackground().getOwnerOfChange());
					projectBackgroundStackHolder.setProjectDescription(bo.getProjectStakeholders().getProjectBackground().getProjectDescription());
					projectBackgroundStackHolder.setProjectName(bo.getProjectStakeholders().getProjectBackground().getProjectName());
					projectBackgroundStackHolder.setTypeOfChange(bo.getProjectStakeholders().getProjectBackground().getTypeOfChange().getMessage());
					projectStakeholdersDto.setProjectBackground(projectBackgroundStackHolder);
				}
				businessBenefitMappingDto.setProjectStakeholders(projectStakeholdersDto);
			}
		}
		return businessBenefitMappingDto;
	}

	
	
	
	
}
