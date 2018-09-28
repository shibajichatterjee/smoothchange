package com.rest.smoothchange.cost.of.change.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.cost.of.change.items.dao.CostOfChangeItemsDao;
import com.rest.smoothchange.cost.of.change.items.dto.CostOfChangeItemsDto;
import com.rest.smoothchange.cost.of.change.items.entity.CostOfChangeItems;
import com.rest.smoothchange.cost.of.change.items.mapper.CostOfChangeItemsMapper;
import com.rest.smoothchange.cost.of.change.items.service.CostOfChangeItemsService;


@Service
@Transactional
public class CostOfChangeItemsServiceImpl extends AbstractService<CostOfChangeItemsDao, CostOfChangeItemsDto, CostOfChangeItemsMapper, CostOfChangeItems>  implements CostOfChangeItemsService{

	
}
