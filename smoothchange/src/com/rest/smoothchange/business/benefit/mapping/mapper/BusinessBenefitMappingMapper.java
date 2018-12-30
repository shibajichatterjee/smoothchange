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
import com.rest.smoothchange.util.BusinessBenefit;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class BusinessBenefitMappingMapper extends AbstractMapper<BusinessBenefitMappingDto , BusinessBenefitMapping>{

	@Override
	public BusinessBenefitMapping mapDtoToEntity(BusinessBenefitMappingDto dto) {
		
		
		BusinessBenefitMapping businessBenefitMapping = null;
		if(dto!=null) {
			businessBenefitMapping = new BusinessBenefitMapping();
			ProjectBackground projectBackground =null;
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
		}
		return businessBenefitMapping;
	}

	@Override
	public BusinessBenefitMappingDto mapEntityToDto(BusinessBenefitMapping bo) {
		BusinessBenefitMappingDto businessBenefitMappingDto = null;
		if(bo!=null) {
			businessBenefitMappingDto = new BusinessBenefitMappingDto();
			ProjectBackgroundDto projectBackground =null;
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
		}
		return businessBenefitMappingDto;
	}

	
	
	
	
}
