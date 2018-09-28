package com.rest.smoothchange.action.plan.training.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.training.items.dao.ActionPlanTrainingItemsDao;
import com.rest.smoothchange.action.plan.training.items.dto.ActionPlanTrainingItemsDto;
import com.rest.smoothchange.action.plan.training.items.entity.ActionPlanTrainingItems;
import com.rest.smoothchange.action.plan.training.items.mapper.ActionPlanTrainingItemsMapper;
import com.rest.smoothchange.action.plan.training.items.service.ActionPlanTrainingItemsService;


@Service
@Transactional
public class ActionPlanTrainingItemsServiceImpl extends AbstractService<ActionPlanTrainingItemsDao, ActionPlanTrainingItemsDto, ActionPlanTrainingItemsMapper, ActionPlanTrainingItems>  implements ActionPlanTrainingItemsService{

	
}
