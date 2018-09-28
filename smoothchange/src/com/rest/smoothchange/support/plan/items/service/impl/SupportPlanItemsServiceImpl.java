package com.rest.smoothchange.support.plan.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.support.plan.items.dao.SupportPlanItemsDao;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;
import com.rest.smoothchange.support.plan.items.entity.SupportPlanItems;
import com.rest.smoothchange.support.plan.items.mapper.SupportPlanItemsMapper;
import com.rest.smoothchange.support.plan.items.service.SupportPlanItemsService;


@Service
@Transactional
public class SupportPlanItemsServiceImpl extends AbstractService<SupportPlanItemsDao, SupportPlanItemsDto, SupportPlanItemsMapper, SupportPlanItems>  implements SupportPlanItemsService{

	
}
