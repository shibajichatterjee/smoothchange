package com.rest.smoothchange.action.plan.items.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;


public interface ActionPlanItemsService extends Service<ActionPlanItemsDto>{
	
	ActionPlanItemsDto getActionPlanItemsByIdProjectId(ActionPlanItemsDto actionPlanItemsDto);
	
	List<ActionPlanItemsDto> getActionPlanItemsListByProjectId(long projectId);

}
