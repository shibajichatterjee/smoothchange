package com.rest.smoothchange.business.benefit.mapping.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.business.benefit.mapping.dao.BusinessBenefitMappingDao;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;
import com.rest.smoothchange.business.benefit.mapping.entity.BusinessBenefitMapping;
import com.rest.smoothchange.business.benefit.mapping.mapper.BusinessBenefitMappingMapper;
import com.rest.smoothchange.business.benefit.mapping.service.BusinessBenefitMappingService;


@Service
@Transactional
public class BusinessBenefitMappingServiceImpl extends AbstractService<BusinessBenefitMappingDao, BusinessBenefitMappingDto, BusinessBenefitMappingMapper, BusinessBenefitMapping>  implements BusinessBenefitMappingService{

	public BusinessBenefitMappingDto getBusinessBenefitMappingByIdProjectId(BusinessBenefitMappingDto businessBenefitMappingDto) {
		return mapper.mapEntityToDto(dao.getBusinessBenefitMappingByIdProjectId(businessBenefitMappingDto));
	}
	
	public List<BusinessBenefitMappingDto> getBusinessBenefitMappingListByProjectId(long projectId){
	   List<BusinessBenefitMappingDto> businessBenefitMappingDtoList = new ArrayList<>();
	   List<BusinessBenefitMapping> businessBenefitMappingList = dao.getBusinessBenefitMappingListByProjectId(projectId);
	   for(BusinessBenefitMapping businessBenefitMapping : businessBenefitMappingList) {
		   businessBenefitMappingDtoList.add(mapper.mapEntityToDto(businessBenefitMapping));
	   }
	   return businessBenefitMappingDtoList;
	}
	
}
