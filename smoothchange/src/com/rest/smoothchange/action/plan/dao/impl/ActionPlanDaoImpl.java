package com.rest.smoothchange.action.plan.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.action.plan.dao.ActionPlanDao;
import com.rest.smoothchange.action.plan.entity.ActionPlan;

@Repository
@Transactional
public class ActionPlanDaoImpl extends AbstractDAO<ActionPlan> implements ActionPlanDao{

	 
}
