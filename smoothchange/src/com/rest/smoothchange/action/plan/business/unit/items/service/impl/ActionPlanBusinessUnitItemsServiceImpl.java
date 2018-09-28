package com.rest.smoothchange.action.plan.business.unit.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.business.unit.items.dao.ActionPlanBusinessUnitItemsDao;
import com.rest.smoothchange.action.plan.business.unit.items.dto.ActionPlanBusinessUnitItemsDto;
import com.rest.smoothchange.action.plan.business.unit.items.entity.ActionPlanBusinessUnitItems;
import com.rest.smoothchange.action.plan.business.unit.items.mapper.ActionPlanBusinessUnitItemsMapper;
import com.rest.smoothchange.action.plan.business.unit.items.service.ActionPlanBusinessUnitItemsService;


@Service
@Transactional
public class ActionPlanBusinessUnitItemsServiceImpl extends AbstractService<ActionPlanBusinessUnitItemsDao, ActionPlanBusinessUnitItemsDto, ActionPlanBusinessUnitItemsMapper, ActionPlanBusinessUnitItems>  implements ActionPlanBusinessUnitItemsService{

	
}
