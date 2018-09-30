package com.rest.smoothchange.implementation.strategy.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyDto;
import com.rest.smoothchange.implementation.strategy.entity.ImplementationStrategy;


public interface ImplementationStrategyDao extends DAO<ImplementationStrategy>{

	public ImplementationStrategy getImplementationStrategyByIdProjectId(ImplementationStrategyDto implementationStrategyDto);
	public List<ImplementationStrategy> getImplementationStrategyListByProjectId(long projectId);
	
	
}
