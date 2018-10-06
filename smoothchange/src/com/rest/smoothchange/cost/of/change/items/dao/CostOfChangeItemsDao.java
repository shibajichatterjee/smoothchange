package com.rest.smoothchange.cost.of.change.items.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.cost.of.change.items.entity.CostOfChangeItems;


public interface CostOfChangeItemsDao extends DAO<CostOfChangeItems>{

	   List<CostOfChangeItems> getCostOfChangeItemListByProjectIdCostOfChageId(long projectId , long costOfChangeId);	 

}
