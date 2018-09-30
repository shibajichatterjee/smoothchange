package com.rest.smoothchange.implementation.strategy.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyDto;


public interface ImplementationStrategyService extends Service<ImplementationStrategyDto>{
	
	public ImplementationStrategyDto getImplementationStrategyByIdProjectId(ImplementationStrategyDto implementationStrategyDto);
	public List<ImplementationStrategyDto> getImplementationStrategyListByProjectId(long projectId);

}
