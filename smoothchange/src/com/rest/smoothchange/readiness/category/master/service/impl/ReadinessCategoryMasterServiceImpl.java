package com.rest.smoothchange.readiness.category.master.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.readiness.category.master.dao.ReadinessCategoryMasterDao;
import com.rest.smoothchange.readiness.category.master.dto.ReadinessCategoryMasterDto;
import com.rest.smoothchange.readiness.category.master.entity.ReadinessCategoryMaster;
import com.rest.smoothchange.readiness.category.master.mapper.ReadinessCategoryMasterMapper;
import com.rest.smoothchange.readiness.category.master.service.ReadinessCategoryMasterService;


@Service
@Transactional
public class ReadinessCategoryMasterServiceImpl extends AbstractService<ReadinessCategoryMasterDao, ReadinessCategoryMasterDto, ReadinessCategoryMasterMapper, ReadinessCategoryMaster>  implements ReadinessCategoryMasterService{

	public  ReadinessCategoryMasterDto getReadinessCategoryMasterDtoByCategoryName(String categoryName) {
		ReadinessCategoryMaster readinessCategoryMaster = dao.getReadinessCategoryMasterDtoByCategoryName(categoryName);
		return mapper.mapEntityToDto(readinessCategoryMaster);
	}
}
