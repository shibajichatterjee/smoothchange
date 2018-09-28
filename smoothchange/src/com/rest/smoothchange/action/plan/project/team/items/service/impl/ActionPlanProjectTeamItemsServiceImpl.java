package com.rest.smoothchange.action.plan.project.team.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.project.team.items.dao.ActionPlanProjectTeamItemsDao;
import com.rest.smoothchange.action.plan.project.team.items.dto.ActionPlanProjectTeamItemsDto;
import com.rest.smoothchange.action.plan.project.team.items.entity.ActionPlanProjectTeamItems;
import com.rest.smoothchange.action.plan.project.team.items.mapper.ActionPlanProjectTeamItemsMapper;
import com.rest.smoothchange.action.plan.project.team.items.service.ActionPlanProjectTeamItemsService;


@Service
@Transactional
public class ActionPlanProjectTeamItemsServiceImpl extends AbstractService<ActionPlanProjectTeamItemsDao, ActionPlanProjectTeamItemsDto, ActionPlanProjectTeamItemsMapper, ActionPlanProjectTeamItems>  implements ActionPlanProjectTeamItemsService{

	
}
