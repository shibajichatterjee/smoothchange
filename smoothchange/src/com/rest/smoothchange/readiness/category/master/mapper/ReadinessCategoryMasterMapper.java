/**
 * 
 */
package com.rest.smoothchange.readiness.category.master.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.readiness.category.master.dto.ReadinessCategoryMasterDto;
import com.rest.smoothchange.readiness.category.master.entity.ReadinessCategoryMaster;

@Component
public class ReadinessCategoryMasterMapper extends AbstractMapper<ReadinessCategoryMasterDto , ReadinessCategoryMaster>{

	@Override
	public ReadinessCategoryMaster mapDtoToEntity(ReadinessCategoryMasterDto dto) {
		ReadinessCategoryMaster readinessCategoryMaster = null;
		   if(dto!=null) { 
			   readinessCategoryMaster = new ReadinessCategoryMaster();
			   readinessCategoryMaster.setChangeReadinessMasterCategoryName(dto.getChangeReadinessMasterCategoryName());
			   readinessCategoryMaster.setId(dto.getId()); 
		   }		
		   return readinessCategoryMaster;
	}

	@Override
	public ReadinessCategoryMasterDto mapEntityToDto(ReadinessCategoryMaster bo) {
		ReadinessCategoryMasterDto readinessCategoryMasterDto = null;
		   if(bo!=null) {
			   readinessCategoryMasterDto = new ReadinessCategoryMasterDto();
			   readinessCategoryMasterDto.setChangeReadinessMasterCategoryName(bo.getChangeReadinessMasterCategoryName());
			   readinessCategoryMasterDto.setId(bo.getId());
		   }		
		   return readinessCategoryMasterDto;
	}	
}
