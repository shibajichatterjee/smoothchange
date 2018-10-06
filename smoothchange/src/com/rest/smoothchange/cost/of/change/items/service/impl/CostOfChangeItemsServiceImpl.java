package com.rest.smoothchange.cost.of.change.items.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.cost.of.change.items.dao.CostOfChangeItemsDao;
import com.rest.smoothchange.cost.of.change.items.dto.CostOfChangeItemsDto;
import com.rest.smoothchange.cost.of.change.items.entity.CostOfChangeItems;
import com.rest.smoothchange.cost.of.change.items.mapper.CostOfChangeItemsMapper;
import com.rest.smoothchange.cost.of.change.items.service.CostOfChangeItemsService;


@Service
@Transactional
public class CostOfChangeItemsServiceImpl extends AbstractService<CostOfChangeItemsDao, CostOfChangeItemsDto, CostOfChangeItemsMapper, CostOfChangeItems>  implements CostOfChangeItemsService{

	public List<CostOfChangeItemsDto> getCostOfChangeItemListByProjectIdCostOfChageId(long projectId , long costOfChangeId){
		List<CostOfChangeItems> costOfChangeItemList = dao.getCostOfChangeItemListByProjectIdCostOfChageId(projectId, costOfChangeId);
		List<CostOfChangeItemsDto> costOfChangeItemsDtoList = new ArrayList<CostOfChangeItemsDto>();
        for(CostOfChangeItems costOfChangeItems : costOfChangeItemList) {
			costOfChangeItemsDtoList.add(mapper.mapEntityToDto(costOfChangeItems));
		}
        return costOfChangeItemsDtoList;
	}
}
