package com.rest.smoothchange.action.plan.audit.items.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.action.plan.audit.items.dao.ActionPlanAuditItemsDao;
import com.rest.smoothchange.action.plan.audit.items.entity.ActionPlanAuditItems;

@Repository
@Transactional
public class ActionPlanAuditItemsDaoImpl extends AbstractDAO<ActionPlanAuditItems> implements ActionPlanAuditItemsDao{

	 
}
