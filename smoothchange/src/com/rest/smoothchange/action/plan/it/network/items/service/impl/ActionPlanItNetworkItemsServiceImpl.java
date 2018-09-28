package com.rest.smoothchange.action.plan.it.network.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.it.network.items.dao.ActionPlanItNetworkItemsDao;
import com.rest.smoothchange.action.plan.it.network.items.dto.ActionPlanItNetworkItemsDto;
import com.rest.smoothchange.action.plan.it.network.items.entity.ActionPlanItNetworkItems;
import com.rest.smoothchange.action.plan.it.network.items.mapper.ActionPlanItNetworkItemsMapper;
import com.rest.smoothchange.action.plan.it.network.items.service.ActionPlanItNetworkItemsService;


@Service
@Transactional
public class ActionPlanItNetworkItemsServiceImpl extends AbstractService<ActionPlanItNetworkItemsDao, ActionPlanItNetworkItemsDto, ActionPlanItNetworkItemsMapper, ActionPlanItNetworkItems>  implements ActionPlanItNetworkItemsService{

	
}
