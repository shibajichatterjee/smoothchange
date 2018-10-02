/**
 * 
 */
package com.rest.smoothchange.organization.info.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.organization.info.dto.OrganizationInfoDto;
import com.rest.smoothchange.organization.info.entity.OrganizationInfo;

@Component
public class OrganizationInfoMapper extends AbstractMapper<OrganizationInfoDto , OrganizationInfo>{

	@Override
	public OrganizationInfo mapDtoToEntity(OrganizationInfoDto dto) {
		OrganizationInfo organizationInfo = null;
		if(dto!=null) {
			organizationInfo = new OrganizationInfo();
			organizationInfo.setAddress(dto.getAddress());
			organizationInfo.setId(dto.getId());
			organizationInfo.setLogo(dto.getLogo());
			organizationInfo.setOrganisationName(dto.getOrganisationName());			
		}
		return organizationInfo;
	}

	@Override
	public OrganizationInfoDto mapEntityToDto(OrganizationInfo bo) {
		OrganizationInfoDto organizationInfoDto = null;
		if(bo!=null) {
			organizationInfoDto = new OrganizationInfoDto();
			organizationInfoDto.setAddress(bo.getAddress());
			organizationInfoDto.setId(bo.getId());
			organizationInfoDto.setLogo(bo.getLogo());
			organizationInfoDto.setOrganisationName(bo.getOrganisationName());			
		}
		return organizationInfoDto;
	}
	
	
	
}
