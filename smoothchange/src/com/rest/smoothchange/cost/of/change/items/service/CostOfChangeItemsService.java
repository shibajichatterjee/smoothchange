package com.rest.smoothchange.cost.of.change.items.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.cost.of.change.items.dto.CostOfChangeItemsDto;


public interface CostOfChangeItemsService extends Service<CostOfChangeItemsDto>{
	
	 List<CostOfChangeItemsDto> getCostOfChangeItemListByProjectIdCostOfChageId(long projectId , long costOfChangeId);	

}
