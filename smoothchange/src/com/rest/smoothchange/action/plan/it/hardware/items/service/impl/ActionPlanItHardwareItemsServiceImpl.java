package com.rest.smoothchange.action.plan.it.hardware.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.it.hardware.items.dao.ActionPlanItHardwareItemsDao;
import com.rest.smoothchange.action.plan.it.hardware.items.dto.ActionPlanItHardwareItemsDto;
import com.rest.smoothchange.action.plan.it.hardware.items.entity.ActionPlanItHardwareItems;
import com.rest.smoothchange.action.plan.it.hardware.items.mapper.ActionPlanItHardwareItemsMapper;
import com.rest.smoothchange.action.plan.it.hardware.items.service.ActionPlanItHardwareItemsService;


@Service
@Transactional
public class ActionPlanItHardwareItemsServiceImpl extends AbstractService<ActionPlanItHardwareItemsDao, ActionPlanItHardwareItemsDto, ActionPlanItHardwareItemsMapper, ActionPlanItHardwareItems>  implements ActionPlanItHardwareItemsService{

	
}
