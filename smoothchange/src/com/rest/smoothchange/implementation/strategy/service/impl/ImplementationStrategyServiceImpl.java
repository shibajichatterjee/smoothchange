package com.rest.smoothchange.implementation.strategy.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.implementation.strategy.dao.ImplementationStrategyDao;
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyDto;
import com.rest.smoothchange.implementation.strategy.entity.ImplementationStrategy;
import com.rest.smoothchange.implementation.strategy.mapper.ImplementationStrategyMapper;
import com.rest.smoothchange.implementation.strategy.service.ImplementationStrategyService;


@Service
@Transactional
public class ImplementationStrategyServiceImpl extends AbstractService<ImplementationStrategyDao, ImplementationStrategyDto, ImplementationStrategyMapper, ImplementationStrategy>  implements ImplementationStrategyService{

	public ImplementationStrategyDto getImplementationStrategyByIdProjectId(ImplementationStrategyDto implementationStrategyDto) {
		return mapper.mapEntityToDto(dao.getImplementationStrategyByIdProjectId(implementationStrategyDto));
	}
	
	public List<ImplementationStrategyDto> getImplementationStrategyListByProjectId(long projectId){
		List<ImplementationStrategyDto> implementationStrategyDtoList = new ArrayList<>();
		List<ImplementationStrategy> implementationStrategyList = dao.getImplementationStrategyListByProjectId(projectId);
		for(ImplementationStrategy implementationStrategy : implementationStrategyList) {
			implementationStrategyDtoList.add(mapper.mapEntityToDto(implementationStrategy));
		}
		
		return implementationStrategyDtoList;
	}
	
}
