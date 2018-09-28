package com.rest.smoothchange.implementation.strategy.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.implementation.strategy.dao.ImplementationStrategyDao;
import com.rest.smoothchange.implementation.strategy.entity.ImplementationStrategy;

@Repository
@Transactional
public class ImplementationStrategyDaoImpl extends AbstractDAO<ImplementationStrategy> implements ImplementationStrategyDao{

	 
}
