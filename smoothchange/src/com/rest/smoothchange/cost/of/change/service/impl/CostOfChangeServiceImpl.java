package com.rest.smoothchange.cost.of.change.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.cost.of.change.dao.CostOfChangeDao;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;
import com.rest.smoothchange.cost.of.change.mapper.CostOfChangeMapper;
import com.rest.smoothchange.cost.of.change.service.CostOfChangeService;


@Service
@Transactional
public class CostOfChangeServiceImpl extends AbstractService<CostOfChangeDao, CostOfChangeDto, CostOfChangeMapper, CostOfChange>  implements CostOfChangeService{

	
}
