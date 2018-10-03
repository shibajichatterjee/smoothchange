package com.rest.smoothchange.action.plan.items.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.action.plan.items.entity.ActionPlanItems;

public interface ActionPlanItemsDao extends DAO<ActionPlanItems> {

	public ActionPlanItems getActionPlanItemsByIdProjectId(ActionPlanItemsDto actionPlanItemsDto);
	public List<ActionPlanItems> getActionPlanItemsByProjectId(long projectId);

}
