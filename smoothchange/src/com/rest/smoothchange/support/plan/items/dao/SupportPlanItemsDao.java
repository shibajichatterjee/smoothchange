package com.rest.smoothchange.support.plan.items.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;
import com.rest.smoothchange.support.plan.items.entity.SupportPlanItems;


public interface SupportPlanItemsDao extends DAO<SupportPlanItems>{

	
	public SupportPlanItems getSupportPlanItemsByIdProjectId(SupportPlanItemsDto supportPlanItemsDto);
	
	public List<SupportPlanItems> getSupportPlanItemsListByProjectId(long projectId);
	
}
