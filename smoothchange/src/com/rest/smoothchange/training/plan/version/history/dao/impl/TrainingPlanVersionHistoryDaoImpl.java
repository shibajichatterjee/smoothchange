package com.rest.smoothchange.training.plan.version.history.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.training.plan.version.history.dao.TrainingPlanVersionHistoryDao;
import com.rest.smoothchange.training.plan.version.history.entity.TrainingPlanVersionHistory;

@Repository
@Transactional
public class TrainingPlanVersionHistoryDaoImpl extends AbstractDAO<TrainingPlanVersionHistory> implements TrainingPlanVersionHistoryDao{

	 
}
