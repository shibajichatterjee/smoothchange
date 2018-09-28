package com.rest.smoothchange.training.plan.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.training.plan.dao.TrainingPlanDao;
import com.rest.smoothchange.training.plan.entity.TrainingPlan;

@Repository
@Transactional
public class TrainingPlanDaoImpl extends AbstractDAO<TrainingPlan> implements TrainingPlanDao{

	 
}
