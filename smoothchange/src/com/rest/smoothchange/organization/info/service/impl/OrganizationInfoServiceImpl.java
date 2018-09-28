package com.rest.smoothchange.organization.info.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.organization.info.dao.OrganizationInfoDao;
import com.rest.smoothchange.organization.info.dto.OrganizationInfoDto;
import com.rest.smoothchange.organization.info.entity.OrganizationInfo;
import com.rest.smoothchange.organization.info.mapper.OrganizationInfoMapper;
import com.rest.smoothchange.organization.info.service.OrganizationInfoService;


@Service
@Transactional
public class OrganizationInfoServiceImpl extends AbstractService<OrganizationInfoDao, OrganizationInfoDto, OrganizationInfoMapper, OrganizationInfo>  implements OrganizationInfoService{

	
}
