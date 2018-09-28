package com.rest.smoothchange.cost.of.change.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.cost.of.change.dao.CostOfChangeDao;
import com.rest.smoothchange.cost.of.change.entity.CostOfChange;

@Repository
@Transactional
public class CostOfChangeDaoImpl extends AbstractDAO<CostOfChange> implements CostOfChangeDao{

	 
}
