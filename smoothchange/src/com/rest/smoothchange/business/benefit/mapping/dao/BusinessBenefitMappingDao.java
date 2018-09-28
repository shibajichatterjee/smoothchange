package com.rest.smoothchange.business.benefit.mapping.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;
import com.rest.smoothchange.business.benefit.mapping.entity.BusinessBenefitMapping;


public interface BusinessBenefitMappingDao extends DAO<BusinessBenefitMapping>{

	public BusinessBenefitMapping getBusinessBenefitMappingByIdProjectId(BusinessBenefitMappingDto businessBenefitMappingDto);
	public List<BusinessBenefitMapping> getBusinessBenefitMappingListByProjectId(long projectId);
	
}
