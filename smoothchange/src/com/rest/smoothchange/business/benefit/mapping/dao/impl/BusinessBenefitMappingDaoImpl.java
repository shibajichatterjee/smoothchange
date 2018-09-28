package com.rest.smoothchange.business.benefit.mapping.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.business.benefit.mapping.dao.BusinessBenefitMappingDao;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;
import com.rest.smoothchange.business.benefit.mapping.entity.BusinessBenefitMapping;

@Repository
@Transactional
public class BusinessBenefitMappingDaoImpl extends AbstractDAO<BusinessBenefitMapping> implements BusinessBenefitMappingDao{

	public BusinessBenefitMapping getBusinessBenefitMappingByIdProjectId(BusinessBenefitMappingDto businessBenefitMappingDto) {
		Criteria criteria = getSession().createCriteria(BusinessBenefitMapping.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", businessBenefitMappingDto.getProjectBackground().getId()),Restrictions.eq("id", businessBenefitMappingDto.getId())));
		return (BusinessBenefitMapping)criteria.uniqueResult();
	}
	
	public List<BusinessBenefitMapping> getBusinessBenefitMappingListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(BusinessBenefitMapping.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
	
	 
}
