package com.rest.smoothchange.readiness.category.items.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.readiness.category.items.dao.ReadinessCategoryItemsDao;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;
import com.rest.smoothchange.readiness.category.items.mapper.ReadinessCategoryItemsMapper;
import com.rest.smoothchange.readiness.category.items.service.ReadinessCategoryItemsService;


@Service
@Transactional
public class ReadinessCategoryItemsServiceImpl extends AbstractService<ReadinessCategoryItemsDao, ReadinessCategoryItemsDto, ReadinessCategoryItemsMapper, ReadinessCategoryItems>  implements ReadinessCategoryItemsService{

	
	
	
}
