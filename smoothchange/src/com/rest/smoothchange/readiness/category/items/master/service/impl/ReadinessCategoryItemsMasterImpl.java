package com.rest.smoothchange.readiness.category.items.master.service.impl;


import java.util.ArrayList;
import java.util.List;

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

  public List<ReadinessCategoryItemsMasterDto> getReadinessCategoryItemsMasterByCategoryMasterId(long categoryMasterId){
	  List<ReadinessCategoryItemsMasterDto> readinessCategoryItemsMasterDtoList = new ArrayList<>();
	  List<ReadinessCategoryItemsMaster> readinessCategoryItemsMasterList = dao.getReadinessCategoryItemsMasterByCategoryMasterId(categoryMasterId);
	  for(ReadinessCategoryItemsMaster readinessCategoryItemsMaster:readinessCategoryItemsMasterList) {
		  readinessCategoryItemsMasterDtoList.add(mapper.mapEntityToDto(readinessCategoryItemsMaster));
	  }	  
	  return readinessCategoryItemsMasterDtoList;
  }
  
  public ReadinessCategoryItemsMasterDto getReadinessCategoryItemsMasterByCategoryItemCode(String itemCodeCode) {
	  ReadinessCategoryItemsMaster readinessCategoryItemsMaster = dao.getReadinessCategoryItemsMasterByCategoryItemCode(itemCodeCode);
	  return mapper.mapEntityToDto(readinessCategoryItemsMaster);
  }
  
  
  
}
