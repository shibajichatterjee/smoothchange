package com.rest.smoothchange.action.plan.items.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.action.plan.items.dao.ActionPlanItemsDao;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.action.plan.items.entity.ActionPlanItems;
import com.rest.smoothchange.action.plan.items.mapper.ActionPlanItemsMapper;
import com.rest.smoothchange.action.plan.items.service.ActionPlanItemsService;


@Service
@Transactional
public class ActionPlanItemsServiceImpl extends AbstractService<ActionPlanItemsDao, ActionPlanItemsDto, ActionPlanItemsMapper, ActionPlanItems>  implements ActionPlanItemsService{

	public ActionPlanItemsDto getActionPlanItemsByIdProjectId(ActionPlanItemsDto actionPlanItemsDto) {
		return mapper.mapEntityToDto(dao.getActionPlanItemsByIdProjectId(actionPlanItemsDto));
	}
	
	public List<ActionPlanItemsDto> getActionPlanItemsListByProjectId(long projectId){
		List<ActionPlanItemsDto> actionPlanItemsDtoList = new ArrayList<>();
		try
		{
		List<ActionPlanItems> actionPlanItemList = dao.getActionPlanItemsByProjectId(projectId);
		for(ActionPlanItems actionPlanItems : actionPlanItemList ) {
			actionPlanItemsDtoList.add(mapper.mapEntityToDto(actionPlanItems));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return actionPlanItemsDtoList;
	}
}
