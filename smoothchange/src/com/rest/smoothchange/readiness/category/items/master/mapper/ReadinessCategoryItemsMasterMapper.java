/**
 * 
 */
package com.rest.smoothchange.readiness.category.items.master.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.readiness.category.items.master.dto.ReadinessCategoryItemsMasterDto;
import com.rest.smoothchange.readiness.category.items.master.entity.ReadinessCategoryItemsMaster;
import com.rest.smoothchange.readiness.category.master.dto.ReadinessCategoryMasterDto;
import com.rest.smoothchange.readiness.category.master.entity.ReadinessCategoryMaster;

@Component
public class ReadinessCategoryItemsMasterMapper extends AbstractMapper<ReadinessCategoryItemsMasterDto , ReadinessCategoryItemsMaster>{

	@Override
	public ReadinessCategoryItemsMaster mapDtoToEntity(ReadinessCategoryItemsMasterDto dto) {
		ReadinessCategoryItemsMaster readinessCategoryItemsMaster = null;
		ReadinessCategoryMaster readinessCategoryMaster = null;
		   if(dto!=null) { 
			   readinessCategoryItemsMaster = new ReadinessCategoryItemsMaster();
			   readinessCategoryItemsMaster.setChangeReadinessMasterCategoryItemCode(dto.getChangeReadinessMasterCategoryItemCode());
			   readinessCategoryItemsMaster.setChangeReadinessMasterCategoryItemDescription(dto.getChangeReadinessMasterCategoryItemDescription());
			   readinessCategoryItemsMaster.setId(dto.getId());
			   if(dto.getReadinessCategoryMaster()!=null) {
				   readinessCategoryMaster = new ReadinessCategoryMaster();
				   readinessCategoryMaster.setChangeReadinessMasterCategoryName(dto.getReadinessCategoryMaster().getChangeReadinessMasterCategoryName());
				   readinessCategoryMaster.setId(dto.getReadinessCategoryMaster().getId()); 
				   readinessCategoryItemsMaster.setReadinessCategoryMaster(readinessCategoryMaster);
			   }
		   }		
		   return readinessCategoryItemsMaster;
	}

	@Override
	public ReadinessCategoryItemsMasterDto mapEntityToDto(ReadinessCategoryItemsMaster bo) {
		ReadinessCategoryItemsMasterDto readinessCategoryItemsMaster = null;
		ReadinessCategoryMasterDto readinessCategoryMaster = null;
		   if(bo!=null) { 
			   readinessCategoryItemsMaster = new ReadinessCategoryItemsMasterDto();
			   readinessCategoryItemsMaster.setChangeReadinessMasterCategoryItemCode(bo.getChangeReadinessMasterCategoryItemCode());
			   readinessCategoryItemsMaster.setChangeReadinessMasterCategoryItemDescription(bo.getChangeReadinessMasterCategoryItemDescription());
			   readinessCategoryItemsMaster.setId(bo.getId());
			   if(bo.getReadinessCategoryMaster()!=null) {
				   readinessCategoryMaster = new ReadinessCategoryMasterDto();
				   readinessCategoryMaster.setChangeReadinessMasterCategoryName(bo.getReadinessCategoryMaster().getChangeReadinessMasterCategoryName());
				   readinessCategoryMaster.setId(bo.getReadinessCategoryMaster().getId()); 
				   readinessCategoryItemsMaster.setReadinessCategoryMaster(readinessCategoryMaster);
			   }
		   }		
		   return readinessCategoryItemsMaster;
	}	
}
