package com.rest.smoothchange.organization.info.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.organization.info.dao.OrganizationInfoDao;
import com.rest.smoothchange.organization.info.entity.OrganizationInfo;

@Repository
@Transactional
public class OrganizationInfoDaoImpl extends AbstractDAO<OrganizationInfo> implements OrganizationInfoDao{

	 
}
