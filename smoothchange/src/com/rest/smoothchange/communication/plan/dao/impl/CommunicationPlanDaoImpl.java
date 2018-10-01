package com.rest.smoothchange.communication.plan.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.communication.plan.dao.CommunicationPlanDao;
import com.rest.smoothchange.communication.plan.entity.CommunicationPlan;

@Repository
@Transactional
public class CommunicationPlanDaoImpl extends AbstractDAO<CommunicationPlan> implements CommunicationPlanDao{

	 
}
