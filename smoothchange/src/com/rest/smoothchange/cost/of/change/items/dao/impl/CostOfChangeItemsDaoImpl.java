package com.rest.smoothchange.cost.of.change.items.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.cost.of.change.items.dao.CostOfChangeItemsDao;
import com.rest.smoothchange.cost.of.change.items.entity.CostOfChangeItems;

@Repository
@Transactional
public class CostOfChangeItemsDaoImpl extends AbstractDAO<CostOfChangeItems> implements CostOfChangeItemsDao{

	 
}
