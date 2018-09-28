package com.rest.smoothchange.readiness.category.items.master.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.readiness.category.items.master.dao.ReadinessCategoryItemsMasterDao;
import com.rest.smoothchange.readiness.category.items.master.dto.ReadinessCategoryItemsMasterDto;
import com.rest.smoothchange.readiness.category.items.master.entity.ReadinessCategoryItemsMaster;
import com.rest.smoothchange.readiness.category.items.master.mapper.ReadinessCategoryItemsMasterMapper;
import com.rest.smoothchange.readiness.category.items.master.service.ReadinessCategoryItemsMasterService;


@Service
@Transactional
public class ReadinessCategoryItemsMasterImpl extends AbstractService<ReadinessCategoryItemsMasterDao, ReadinessCategoryItemsMasterDto, ReadinessCategoryItemsMasterMapper, ReadinessCategoryItemsMaster>  implements ReadinessCategoryItemsMasterService{

	
}
