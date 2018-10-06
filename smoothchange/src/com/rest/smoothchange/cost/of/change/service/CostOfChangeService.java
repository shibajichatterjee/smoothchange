package com.rest.smoothchange.cost.of.change.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;


public interface CostOfChangeService extends Service<CostOfChangeDto>{
	
	CostOfChangeDto getCostOfChangeByIdProjectId(CostOfChangeDto costOfChangeDto);
	List<CostOfChangeDto> getCostOfChangeListByProjectId(long projectId);

}
