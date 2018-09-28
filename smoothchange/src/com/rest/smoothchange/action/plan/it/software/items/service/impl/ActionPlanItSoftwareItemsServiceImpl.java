package com.rest.smoothchange.action.plan.it.software.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.it.software.items.dao.ActionPlanItSoftwareItemsDao;
import com.rest.smoothchange.action.plan.it.software.items.dto.ActionPlanItSoftwareItemsDto;
import com.rest.smoothchange.action.plan.it.software.items.mapper.ActionPlanItSoftwareItemsMapper;
import com.rest.smoothchange.action.plan.it.software.items.service.ActionPlanItSoftwareItemsService;


@Service
@Transactional
public class ActionPlanItSoftwareItemsServiceImpl extends AbstractService<ActionPlanItSoftwareItemsDao, ActionPlanItSoftwareItemsDto, ActionPlanItSoftwareItemsMapper, ActionPlanItSoftwareItemsDto>  implements ActionPlanItSoftwareItemsService{

	
}
