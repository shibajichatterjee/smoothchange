package com.rest.smoothchange.action.plan.audit.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.audit.items.dao.ActionPlanAuditItemsDao;
import com.rest.smoothchange.action.plan.audit.items.dto.ActionPlanAuditItemsDto;
import com.rest.smoothchange.action.plan.audit.items.entity.ActionPlanAuditItems;
import com.rest.smoothchange.action.plan.audit.items.mapper.ActionPlanAuditItemsMapper;
import com.rest.smoothchange.action.plan.audit.items.service.ActionPlanAuditItemsService;


@Service
@Transactional
public class ActionPlanAuditItemsServiceImpl extends AbstractService<ActionPlanAuditItemsDao, ActionPlanAuditItemsDto, ActionPlanAuditItemsMapper, ActionPlanAuditItems>  implements ActionPlanAuditItemsService{

	
}
