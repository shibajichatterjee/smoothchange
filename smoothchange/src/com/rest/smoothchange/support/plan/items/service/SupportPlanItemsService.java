package com.rest.smoothchange.support.plan.items.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;


public interface SupportPlanItemsService extends Service<SupportPlanItemsDto>{
	
    public SupportPlanItemsDto getSupportPlanItemsByIdProjectId(SupportPlanItemsDto supportPlanItemsDto);
	
	public List<SupportPlanItemsDto> getSupportPlanItemsListByProjectId(long projectId);

}
