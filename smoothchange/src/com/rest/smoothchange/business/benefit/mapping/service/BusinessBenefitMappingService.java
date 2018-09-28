package com.rest.smoothchange.business.benefit.mapping.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;


public interface BusinessBenefitMappingService extends Service<BusinessBenefitMappingDto>{
	
	public BusinessBenefitMappingDto getBusinessBenefitMappingByIdProjectId(BusinessBenefitMappingDto businessBenefitMappingDto);
	public List<BusinessBenefitMappingDto> getBusinessBenefitMappingListByProjectId(long projectId);

}
