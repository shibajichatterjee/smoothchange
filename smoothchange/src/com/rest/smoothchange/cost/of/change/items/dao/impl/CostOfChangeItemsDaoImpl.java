package com.rest.smoothchange.cost.of.change.items.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.cost.of.change.items.dao.CostOfChangeItemsDao;
import com.rest.smoothchange.cost.of.change.items.entity.CostOfChangeItems;

@Repository
@Transactional
public class CostOfChangeItemsDaoImpl extends AbstractDAO<CostOfChangeItems> implements CostOfChangeItemsDao{

	
  public List<CostOfChangeItems> getCostOfChangeItemListByProjectIdCostOfChageId(long projectId , long costOfChangeId){
	  Criteria criteria = getSession().createCriteria(CostOfChangeItems.class);
	  criteria.createAlias("costOfChange", "costOfChange" , JoinType.LEFT_OUTER_JOIN);
	  criteria.createAlias("costOfChange.projectBackground", "projectBackground" , JoinType.LEFT_OUTER_JOIN);
	  if(projectId>0) {
		  criteria.add(Restrictions.eq("projectBackground.id", projectId));
	  }if(costOfChangeId>0) {
		  criteria.add(Restrictions.eq("costOfChange.id", costOfChangeId));
	  }
	  return criteria.list();
  }
	 
}
