package com.rest.smoothchange.support.plan.items.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.support.plan.items.dao.SupportPlanItemsDao;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;
import com.rest.smoothchange.support.plan.items.entity.SupportPlanItems;
import com.rest.smoothchange.support.plan.items.mapper.SupportPlanItemsMapper;
import com.rest.smoothchange.support.plan.items.service.SupportPlanItemsService;


@Service
@Transactional
public class SupportPlanItemsServiceImpl extends AbstractService<SupportPlanItemsDao, SupportPlanItemsDto, SupportPlanItemsMapper, SupportPlanItems>  implements SupportPlanItemsService{

	public SupportPlanItemsDto getSupportPlanItemsByIdProjectId(SupportPlanItemsDto supportPlanItemsDto) {
		return mapper.mapEntityToDto(dao.getSupportPlanItemsByIdProjectId(supportPlanItemsDto));
	}
	
	public List<SupportPlanItemsDto> getSupportPlanItemsListByProjectId(long projectId){
		List<SupportPlanItemsDto> supportPlanItemsDtoList = new ArrayList<>();
		try
		{
		List<SupportPlanItems> supportPlanItemsList = dao.getSupportPlanItemsListByProjectId(projectId);
		for(SupportPlanItems supportPlanItems : supportPlanItemsList ) {
			supportPlanItemsDtoList.add(mapper.mapEntityToDto(supportPlanItems));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return supportPlanItemsDtoList;
	}
}
