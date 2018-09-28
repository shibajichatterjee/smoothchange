package com.rest.smoothchange.implementation.strategy.service.impl;


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

	
}
