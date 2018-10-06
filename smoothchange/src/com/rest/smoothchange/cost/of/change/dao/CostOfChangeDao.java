package com.rest.smoothchange.cost.of.change.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;


public interface CostOfChangeDao extends DAO<CostOfChange>{

	
	 CostOfChange getCostOfChangeByIdProjectId(CostOfChangeDto costOfChangeDto);
	 List<CostOfChange> getCostOfChangeListByProjectId(long projectId);
	
}
