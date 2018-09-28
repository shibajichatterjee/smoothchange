package com.rest.smoothchange.action.plan.communication.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.communication.items.dao.ActionPlanCommunicationItemsDao;
import com.rest.smoothchange.action.plan.communication.items.dto.ActionPlanCommunicationItemsDto;
import com.rest.smoothchange.action.plan.communication.items.entity.ActionPlanCommunicationItems;
import com.rest.smoothchange.action.plan.communication.items.mapper.ActionPlanCommunicationItemsMapper;
import com.rest.smoothchange.action.plan.communication.items.service.ActionPlanCommunicationItemsService;


@Service
@Transactional
public class ActionPlanCommunicationItemsServiceImpl extends AbstractService<ActionPlanCommunicationItemsDao, ActionPlanCommunicationItemsDto, ActionPlanCommunicationItemsMapper, ActionPlanCommunicationItems>  implements ActionPlanCommunicationItemsService{

	
}
